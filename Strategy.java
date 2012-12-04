import java.util.LinkedList;
import java.util.Queue;
/**
 * Strategy
 *
 * A strategy by which a cars moves.
 * 
 */
public abstract class Strategy {
	private int width;
	private int height;
	
	public Strategy (Grid grid) {
		this.width = grid.width;
		this.height = grid.height;
	}
	
	/**
	 * The next move for a FlexCar, a number between -2 and 2.  
	 *         -2 left, -1 forward-left, 0 forward, 1 forward-right, 2 right
	 **/
	public int nextMove(FlexCar car) {
		Queue<Integer> validDirections = new LinkedList<Integer>();
		for(int direction = 2; direction >= -2; direction--) {
			Direction value = car.getDirection().rotate45(direction);
			int x = car.getX() + value.x;
			int y = car.getY() + value.y;
			if(!(x >= width || y >= height || x < 0 || y < 0)) 
				validDirections.add(direction);
		}
		
		int[] possibles = queueToArray(validDirections);
		return calcNextMove(possibles);
	}
	
	static final Direction LEFT = new Direction(3),
			RIGHT = new Direction(1),
			TOP = new Direction(0),
			BOTTOM = new Direction(2);
	
	/**
	 * The next move for a FastCar, a number between -1 and 1. 
	 *         -1 forward-left, 0 forward, 1 forward-right
	 */
	public int nextMove(FastCar car) {
		Queue<Integer> validDirections = new LinkedList<Integer>();
		for(int i = 1; i >= -1; i--) {
			Direction carDir = car.getDirection();
			Direction value = carDir.rotate45(i);
			Direction newDirection = carDir.rotate90((int) Math.signum(i));
			
			int x = car.getX() + value.x;
			int y = car.getY() + value.y;
			
			if(!(x >= width || y >= height || x < 0 || y < 0)) {
				if(!((x >= width-1 && LEFT.isOpposite(newDirection))
						|| (x <= 1 && RIGHT.isOpposite(newDirection))	
						|| (y >= height-1 && TOP.isOpposite(newDirection))
						|| (y <= 1 && BOTTOM.isOpposite(newDirection))))
					validDirections.add(i);
			}
				
		}
		
		int[] possibles = queueToArray(validDirections);
		return calcNextMove(possibles);
	}

	private int[] queueToArray(Queue<Integer> validDirections) {
		int[] possibles = new int[validDirections.size()];
		int counter = -1;
		while(!validDirections.isEmpty())
			possibles[++counter] = validDirections.poll();
		return possibles;
	}
	
	public abstract int calcNextMove(int[] possible);
	
}