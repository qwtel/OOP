
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
