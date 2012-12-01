/**
 * FastCar
 *
 * Represents a fast car.
 */
public class FastCar extends Car {

    protected int velocity = 25;

    /**
     * Initializes a new car with a random direction and position.
     *
     * @param name The name of the car.
     * @param grid The grid on which the car moves.
     * @param strat The strategy by which the car moves.
     */
	public FastCar(String name, Grid grid, Strategy strat) {            
        super(name, grid, strat);
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
	public FastCar(String name, Grid grid, Strategy strat, int x, int y, int dir) {
        super(name, grid, strat, x, y, dir);
	}

    protected int getVelocity() {
        return velocity;
    }
}
