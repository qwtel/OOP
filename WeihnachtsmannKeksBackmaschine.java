/**
 * Eine Backmaschine erstellt ein WeihnachtsmannKeks aus einer Position.
 */
class WeihnachtsmannKeksBackmaschine implements Backmaschine {

	/**
	 * @param p Eine gueltige Position.
	 * @return Das entsprechende WeihnachtsmannKeks.
	 */
	@Override
	public Keks create(Position p) {
		return new WeihnachtsmannKeks(p.getTeigart());
	}
}
