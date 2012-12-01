/**
 * StrategyRandom
 *
 * A strategy which returns a random direction.
 */
public class StrategyRandom implements Strategy {

	@Override
	public int nextMove() {		
		return ((int)Math.round((Math.random()*4)))-2;
	}
}