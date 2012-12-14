/**
 * Eine Backmaschine erstellt ein MondKeks aus einer Position.
 */
class MondKeksBackmaschine implements Backmaschine {

	/**
	 * @param p Eine gültige Position.
	 * @return Das entsprechende MondKeks.
	 */
	@Override
	public Keks create(Position p) {
		return new MondKeks(p.getTeigart());
	}
}
