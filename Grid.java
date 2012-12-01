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
    }
    
    
    private void fillGrid() {
		for(int h =0; h<height; h++) {
			for (int w = 0; w < width; w++) {
				grid[w][h]= new Field();
			}
		}
		
	}
	private class Field {
    	private List<Car> list;
    	public Field() {
    		list = Collections.synchronizedList(new ArrayList<Car>());
    	}
    	
    }
}
