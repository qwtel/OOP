/**
	 * Represents one of the 2D grid directions.
	 * N, NE, E, SE, S, SW, W, NW;
	 */
	public class Direction {
		final int x;
		final int y;

		/**
		 * @param x An integer between -1 and 1, but not 0 if y is 0.
		 * @param y An integer between -1 and 1, but not 0 if x is 0.
		 */
		public Direction(int x, int y) {
			this.x = x;
			this.y = y;
		}

		/**
		 * "Rotates" this Direction by 45 degrees n times.
		 * @param n An integer between -2 and +2. 
		 * @return The direction after a rotation as a valid Direction.
		 */
		public Direction rotate45(int n) {
			double mathAngle = Math.PI/4 * n;
			double cs = Math.cos(mathAngle);
			double sn = Math.sin(mathAngle);
			int px = (int)Math.round(x*cs - y*sn);
			int py = (int)Math.round(x*sn + y*cs);
			return new Direction(px, py);
		}

		/**
		 * "Rotates" this Direction by 90 degrees n times.
		 * @param n An integer between -1 and +1.
		 * @return The direction after a rotation as a valid Direction.
		 */
		public Direction rotate90(int n) {
			return rotate45(2*n);
		}

		/**
		 * Checks if the other Direction faces in the opposite direction.
		 *
		 * @param other The other direction.
		 * @return true if this direction is the opposite of the other
		 *         direction.
		 */
		public boolean isOpposite(Direction other) {
			return (x == -other.x) && (y == -other.y);
		}

		@Override
		public String toString() {
			return x + " " + y;
		}

		/**
		 * XXX: Fix for compability with old assertions.
		 * @param dir An integer between 0 and 3, for directions N, E, S, W;
		 *         respectively.
		 */
		public Direction(int dir) {
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
	}