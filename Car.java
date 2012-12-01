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
     * @param name The name of the car.
     * @param grid The grid on which the car moves.
     * @param strat The strategy by which the car moves.
     */
	public Car(String name, Grid grid, Strategy strat) {            
        this.name = name;
        this.grid = grid;
        this.strat = strat;
        this.x = (int)(grid.width*Math.random());
        this.y = (int)(grid.height*Math.random());
		this.dir = 1 + (int)(4*Math.random());
        this.score = 0;
        this.steps = 0;
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
	 * Turns the car left n times if n is negative.
	 * Turns the car right n times if n is positive.
	 *
	 * @param n The number of turns to the left if positive or to the right if
	 *          negative.
	 */
	public void turn(int n) {
		dir = (dir+n)%4;
	}
}
