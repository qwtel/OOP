/**
 * RandomStrategy
 *
 * A strategy which moves in a random direction.
 */
public class RandomStrategy implements Strategy {

	@Override
	public int nextMove() {		
		return ((int)Math.round((Math.random()*4)))-2;
	}
}
