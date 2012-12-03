import java.util.ArrayList;
import java.util.List;

/**
 * Grid
 *
 * Represents a grid on which cars can move.
 */
public class Grid {

	int width;
	int height;
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

	/**
	 * TODO: Needs explanation.
	 */
	public synchronized boolean isRunning() {
		return running;
	}

	/**
	 * TODO: Needs explanation.
	 */
	public void addCar(Car c) {
	 	cars.add(c);
	}

	/**
	 * TODO: Needs explanation.
	 */
	public synchronized void startGame() {
		running = true;
		for(Car c : cars) {
	   		c.start();
		}
	}

	/**
	 * TODO: Needs explanation.
	 */
	public synchronized void endGame() {
		running = false;
	   	for(Car c : cars) {
	   		c.interrupt();
	   	}
		notifyAll();
	}

	/**
	 * TODO: Needs explanation.
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
	 * TODO: Needs explanation.
	 */
	public Field getField(int x, int y) {
		return grid[x][y];
	}
}
