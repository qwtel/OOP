/**
 * Eine Backmaschine erstellt ein Keks aus einer Position.
 */
interface Backmaschine {

	/**
	 * @param p Eine gueltige Position.
	 * @return Das entsprechende Keks.
	 */
	public Keks create(Position p);
}
