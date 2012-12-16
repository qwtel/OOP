/**
 * Eine Backmaschine erstellt ein RundKeks aus einer Position.
 */
class RundKeksBackmaschine implements Backmaschine {

	/**
	 * @param p Eine gueltige Position.
	 * @return Das entsprechende RundKeks.
	 */
	@Override
	public Keks create(Position p) {
		return new RundKeks(p.getTeigart());
	}
}
