/**
 * CircleStrategy
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
