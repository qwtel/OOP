/**
 * Strategy
 *
 * A strategy by which a cars moves.
 */
public interface Strategy {

	/**
	 * @return A number between -2 and 2. 
	 *         -2 left, -1 forward-left, 0 forward, 1 forward-right, 2 right
	 */
	public int nextMove();
}
