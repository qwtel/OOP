/**
 * RandomStrategy
 *
 * A strategy which moves in a random direction.
 */
public class RandomStrategy extends Strategy {

	public RandomStrategy(Grid grid) {
		super(grid);
	}

	@Override
	public synchronized int calcNextMove(int[] possible) {
		int rand = (int) (possible.length * Math.random());
		return possible[rand];
	}
	
}
