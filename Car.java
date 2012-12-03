/**
 * Car
 * 
 * Represents a car.
 */
public abstract class Car extends Thread {

	private int x;
	private int y;

	private Direction direction;

	private String name;
	private Grid grid;
	private Strategy strat;

	/**
	 * The score of this car.
	 */
	private int score;

	/**
	 * The number of moves this car has.
	 */
	protected int steps;
	
	/**
	 * The time between moves. 
	 * Note that a smaller velocity represents a faster car.
	 */
	private int velocity;

	/**
	 * Initializes a new car with a random direction and position.
	 * 
	 * @param name The name of the car.
	 * @param grid The grid on which the car moves.
	 * @param strat The strategy by which the car moves.
	 */
	public Car(String name, Grid grid, Strategy strat, int velocity) {
		this.name = name;
		this.grid = grid;
		this.strat = strat;
		this.x = (int)(grid.width * Math.random());
		this.y = (int)(grid.height * Math.random());
		this.direction = new Direction(1 + (int)(3 * Math.random()));
		this.score = 0;
		this.steps = 0;
		this.velocity = velocity;
	}

	/**
	 * Initializes a new car with with the given paramters.
	 * 
	 * @param name The name of the car.
	 * @param grid The grid on which the car moves.
	 * @param strat The strategy by which the car moves.
	 * @param x The x position of the car.
	 * @param y The y position of the car.
	 * @param dir An integer between 0 and 3, for directions N, E, S, W; 
	 */
	public Car(String name, Grid grid, Strategy strat, int velocity, int x, 
			int y, int dir) {
		this.name = name;
		this.grid = grid;
		this.strat = strat;
		this.x = x;
		this.y = y;
		this.direction = new Direction(dir);
		this.score = 0;
		this.steps = 0;
		this.velocity = velocity;
	}

	@Override
	public void run() {
		while(true) {
			this.steps++;

			int nextMove = strat.nextMove(this);
			Direction nextDirection = direction.rotate90((int)Math.signum(nextMove));
			Direction moveDirection = direction.rotate45(nextMove);
			this.direction = nextDirection;

			int oldX = x;
			int oldY = y;

			this.x += moveDirection.x;
			this.y += moveDirection.y;

			// TODO: The strategy should not allow out of bounds movements.
			/*this.x = (this.x + grid.width)% grid.width;
			this.y = (this.y + grid.height)% grid.height;
			 */
			Field oldField = grid.getField(oldX, oldY);
			Field newField = grid.getField(x, y);
			
			oldField.remove(this);
			this.score += newField.add(this);
			checkScore();
			

			try {
				Thread.sleep(velocity);
			} catch (InterruptedException ex) {
				return;
			}
		}
	}
	
	private void checkScore() {
		if(score >= 10 || steps >= 100) {
			grid.endGame();
			return;
		}
		
	}

	public Direction getDirection() {
		return direction;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	/**
	* TODO
	*/
	public synchronized void collision(Car other) {
		if(direction.isOpposite(other.getDirection())) {
			score++;
			checkScore();
		} else {
			score--;
		}
	}

	@Override
	public String toString() {
		return name + ": " + score;
	}

	//private enum Direction {
	//	N  (new Vec( 0, -1)),
	//	NE (new Vec( 1, -1)),
	//	E  (new Vec( 1,  0)),
	//	SE (new Vec( 1,  1)),
	//	S  (new Vec( 0,  1)),
	//	SW (new Vec(-1,  1)),
	//	W  (new Vec(-1,  0)),
	//	NW (new Vec(-1, -1));
	//
	//	private Vec v;
	//
	//	Direction(Vec v) {
	//		this.v = v;
	//	}
	//
	//	public getVec() {
	//		return v;
	//	}
	//}
	
	//public synchronized void collision(int otherDir) {
	//
	//}
}
