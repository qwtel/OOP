/**
 * Car
 * 
 * Represents a car.
 */
public abstract class Car extends Thread {

	private int x;
	private int y;

	private Vec direction;

	private String name;
	private Grid grid;
	private Strategy strat;

	/**
	 * The score of this car.
	 */
	protected int score;

	/**
	 * The number of moves this car has.
	 */
	protected int steps;
	
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
		this.x = (int) (grid.width * Math.random());
		this.y = (int) (grid.height * Math.random());
		int dir = 1 + (int) (3 * Math.random());
		this.direction = new Vec(dir);
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
		this.direction = new Vec(dir);
		this.score = 0;
		this.steps = 0;
		this.velocity = velocity;
	}

	@Override
	public void run() {
		while(score < 10) {

			try {
				Thread.sleep(velocity);
			} catch (InterruptedException ex) {
				return;
			}

			int nextMove = strat.nextMove();
			Vec nextDirection = direction.rotate90((int)Math.signum(nextMove));
			Vec moveDirection = direction.rotate45(nextMove);

			int oldX = x;
			int oldY = y;

		   	Field oldField = grid.getField(oldX, oldY);
		   	Field newField = grid.getField(x, y);
			
 			/*
			 * Another way to create synchronized code is with synchronized 
			 * statements. Unlike synchronized methods, synchronized statements 
			 * must specify the object that provides the intrinsic lock:
			 */
			synchronized(this) {
				this.steps++;

				this.direction = nextDirection;
				this.x += moveDirection.x;
				this.y += moveDirection.y;

				// TODO: The strategy should not allow out of bounds movements.
				this.x = (this.x + grid.width) % grid.width;
				this.y = (this.y + grid.height) % grid.height;

				oldField.remove(this);
				this.score += newField.add(this);
			}

			if (score >= 10) {
				System.out.println("Wow, da hat wohl jemand gewonnen: " + name
						+ " hat eine Score von " + score + " erreicht.");
			//} else {
			//	System.out.println(name + " : " + score);
			}
		}
	}
	
	/**
	* TODO
	*/
	public int collision(Car other) {
		// TODO
        return 1;
	}

	/**
	 * A 2D grid vector with integer values between -1 and 1.
	 */
	private class Vec {
		final int x;
		final int y;

		/**
		 * @param x An integer between -1 and 1.
		 * @param y An integer between -1 and 1.
		 */
		public Vec(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * XXX: Fix for compability with old assertions.
		 * @param dir An integer between 0 and 3, for directions N, E, S, W;
		 *         respectively.
		 */
		public Vec(int dir) {
			switch(dir) {
				case 0:
					x = 0;
					y = -1;
					break;
				case 1:
					x = 1;
					y = 0;
					break;
				case 2:
					x = 0;
					y = 1;
					break;
				case 3:
					x = -1;
					y = 0;
					break;
				default:
					x = 0;
					y = 0;
					break;
			}
		}

		/**
		 * Rotates this vector by 45 degrees `move` times.
		 * @param move An integer between -2 and +2. 
		 * @return The direction after a rotation as a valid Vec.
		 */
		public Vec rotate45(int move) {
			double mathAngle = Math.PI/4 * move;
			double cs = Math.cos(mathAngle);
			double sn = Math.sin(mathAngle);
			int px = (int)Math.round(x*cs - y*sn);
			int py = (int)Math.round(x*sn + y*cs);
			return new Vec(px, py);
		}

		/**
		 * Rotates this vector by 90 degrees `move` times.
		 * @param move An integer between -1 and +1.
		 * @return The direction after a rotation as a valid Vec.
		 */
		public Vec rotate90(int move) {
			return rotate45(2*move);
		}

		@Override
		public String toString() {
			return x + " " + y;
		}
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
   	//    	return v;
   	//	}
   	//}
	
	//public synchronized void collision(int otherDir) {
	//
	//}
}
