import java.util.ArrayList;
import java.util.Collections;
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

	public synchronized boolean isRunning() {
		return running;
	}

	public void addCar(Car c) {
    	cars.add(c);
	}

	public void startGame() {
		running = true;
		for(Car c : cars) {
    		c.start();
		}
	}

	public synchronized void endGame() {
		running = false;
		notifyAll();
		String s = "";
	   	for(Car c : cars) {
       		c.interrupt();
	   		s += c.name + ": " + c.score + "\n";
	   	}
	}

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
	   		s += c.name + ": " + c.score + "\n";
	   	}
		return s;
	}

	public Field getField(int x, int y) {
		return grid[x][y];
	}
}
