import java.util.ArrayList;
import java.util.List;

/**
 * Grid
 *
 * Represents a grid on which cars can move.
 */
public class Grid {

	protected int width;
	protected int height;
	private Field[][] grid;
	private List<Car> cars;

	private boolean running = false;

	/**
	 * Creates a new grid for cars to move on.
	 *
	 * @param width Width of the grid. 
	 * @param height Height of the grid. 
	 */
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new Field[width][height];
		fillGrid();
		cars = new ArrayList<Car>();
	}
	
	private void fillGrid() {
		for(int h =0; h<height; h++) {
			for (int w = 0; w < width; w++) {
				grid[w][h]= new Field();
			}
		}
	}

	public synchronized boolean isRunning() {
		return running;
	}

	/**
	 * Adds a car to cars
	 */
	public void addCar(Car c) {
	 	cars.add(c);
	}

	/**
	 * Starts a thread for every car in cars 
	 */
	public synchronized void startGame() {
		running = true;
		for(Car c : cars) {
	   		c.start();
		}
	}

	/**
	 * Ends the game.
	 */
	public synchronized void endGame() {
		running = false;
	   	for(Car c : cars) {
	   		c.interrupt();
	   	}
		notifyAll();
	}

	/**
	 * Returns a String with all scores
	 */
	@Override
	public synchronized String toString() {
		while(running) { 
			try {
				// Main thread
				wait();
			} catch (InterruptedException e) {}
		}

		String s = "";
	   	for(Car c : cars) {
	   		s += c.toString() + "\n";
	   	}
		return s;
	}

	/**
	 * Returns the field of a specific position
	 */
	public Field getField(int x, int y) {
		return grid[x][y];
	}
}
