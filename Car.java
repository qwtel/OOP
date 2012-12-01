/**
 * Car
 * 
 * Represents a car.
 */
public abstract class Car extends Thread {

	protected int x;
	protected int y;

	/**
	 * 0 top, 1 left, 2 bottom, 3 right
	 */
	protected int dir;

	protected String name;
	protected Grid grid;
	protected Strategy strat;

	/**
	 * The score of this car.
	 */
	protected int score;

	/**
	 * The number of moves this car has.
	 */
	protected int steps;

	/**
	 * Initializes a new car with a random direction and position.
	 * 
	 * @param name
	 *            The name of the car.
	 * @param grid
	 *            The grid on which the car moves.
	 * @param strat
	 *            The strategy by which the car moves.
	 */
	public Car(String name, Grid grid, Strategy strat) {
		this.name = name;
		this.grid = grid;
		this.strat = strat;
		this.x = (int) (grid.width * Math.random());
		this.y = (int) (grid.height * Math.random());
		this.dir = 1 + (int) (4 * Math.random());
		this.score = 0;
		this.steps = 0;
	}

	/**
	 * Initializes a new car with with the given paramters.
	 * 
	 * @param name
	 *            The name of the car.
	 * @param grid
	 *            The grid on which the car moves.
	 * @param strat
	 *            The strategy by which the car moves.
	 * @param x
	 *            The x position of the car.
	 * @param y
	 *            The y position of the car.
	 * @param dir
	 *            The direction the car faces.
	 */
	public Car(String name, Grid grid, Strategy strat, int x, int y, int dir) {
		this.name = name;
		this.grid = grid;
		this.strat = strat;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.score = 0;
		this.steps = 0;
	}

	/**
	 * Turns the car.
	 * 
	 * Turns the car left n times if n is negative. Turns the car right n times
	 * if n is positive.
	 * 
	 * @param n
	 *            The number of turns to the left if positive or to the right if
	 *            negative.
	 */
	public void turn(int n) {
		dir = (dir + n) % 4;
	}

	abstract protected int getVelocity();

	public int positionCode() {
		return x + y * grid.width;
	}

	public void run() {
		while (score<10) {
			int newPos = dir * 2;
			int nextMove = strat.nextMove();
			newPos = (newPos + nextMove) % 8;
			turn((int) Math.signum(newPos));

			int oldX = x;
			int oldY = y;
			switch (newPos) {
			case 0:
				x += 0;
				y += -1;
				break;
			case 1:
				x += 1;
				y += -1;
				break;
			case 2:
				x += 1;
				y += 0;
				break;
			case 3:
				x += 1;
				y += 1;
				break;
			case 4:
				x += 0;
				y += 1;
				break;
			case 5:
				x += -1;
				y += 1;
				break;
			case 6:
				x += -1;
				y += 0;
				break;
			case 7:
				x += -1;
				y += -1;
				break;
			}
			x = (x + grid.width) % grid.width;
			y = (y + grid.height) % grid.height;
			Field oldField = grid.getField(oldX, oldY);
			Field newField = grid.getField(x, y);
			while (oldField.isLocked() || newField.isLocked()) {
				try {
					synchronized (this) {
						wait();
					}
				} catch (InterruptedException ex) {
					return;
				}
			}
			// Lock them
			oldField.lockedOnOff();
			newField.lockedOnOff();

			oldField.remove(this);
			score += newField.add(this, dir);
			if (score >= 10) {
				System.out.println("Wow, da hat wohl jemand gewonnen: " + name
						+ " hat eine Score von " + score + " erreicht.");
			} else {
				System.out.println(name
						+ " : " + score);
			}
			// Unlock them
			oldField.lockedOnOff();
			newField.lockedOnOff();

			// Wait for next step
			try {
				Thread.sleep(getVelocity());
			} catch (InterruptedException ex) {
			}
		}
	}

	public synchronized void collision(int otherDir) {

	}
}