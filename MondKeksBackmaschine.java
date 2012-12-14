/**
 * Eine Backmaschine, die MondKekse mit der spezifizierten Teigart herstellen
 */
public class MondKeksBackmaschine implements Backmaschine {

	@Override
	public EinzelKeks create(Position p) {
		return new MondKeks(p.getTeigart());
	}

}
