/**
 * CircleStrategy
 * 
 * Returns the first entry in the possible move array, 
 * resulting in a circle-like movement (if not near wall)
 */
public class CircleStrategy extends Strategy {

	public CircleStrategy(Grid grid) {
		super(grid);
	}

	@Override
	public int calcNextMove(int[] possible) {		
		return possible[0];
	}
	
}
