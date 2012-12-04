/**
 * Serpent Strategy
 * Iterates in every step over possible move array and returns the current position,
 * resulting in serpent-like movement (if not near wall).
 *
 */
public class SerpentStrategy extends Strategy {
	int dir;
	public SerpentStrategy(Grid grid) {
		super(grid);
		dir = 0;
	}

	@Override
	public int calcNextMove(int[] possible) {
		dir = (dir++)%possible.length;
		return possible[dir];
	}

}
