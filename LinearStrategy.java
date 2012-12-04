/**
 * Linear Strategy
 * Returns the middle entry in the possible move array,
 * resulting in mostly sraight movement (if not near wall)
 *
 */
public class LinearStrategy extends Strategy {

	public LinearStrategy(Grid grid) {
		super(grid);
	}

	@Override
	public int calcNextMove(int[] possible) {
		return possible[(int) (possible.length/2)];
	}

}
