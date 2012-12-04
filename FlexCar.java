/**
 * FlexCar
 *
 * Represents a flexible car.
 *
 * TODO: Do something to make this class useful, then remove this.
 */
public class FlexCar extends Car {

	/**
	 * Initializes a new car with a random direction and position.
	 *
	 * @param name The name of the car.
	 * @param grid The grid on which the car moves.
	 * @param strat The strategy by which the car moves.
	 */
	public FlexCar(String name, Grid grid, Strategy strat, int velocity) {
		super(name, grid, strat, velocity);
	}

	/**
	 * Initializes a new car with with the given paramters.
	 *
	 * @param name The name of the car.
	 * @param grid The grid on which the car moves.
	 * @param strat The strategy by which the car moves.
	 * @param x The x position of the car.
	 * @param y The y position of the car.
	 * @param dir The direction the car faces.
	 */
	public FlexCar(String name, Grid grid, Strategy strat, int velocity, int x,
			int y, int dir) {
		super(name, grid, strat, velocity, x, y, dir);
	}

	@Override
	public int getThisCarMove(Car car) {
		return getStrategy().nextMove(this);
	}
}
