/**
 * Eine Backmaschine, die RundKekse mit der spezifizierten Teigart herstellen
 */
public class RundKeksBackmaschine implements Backmaschine {

	@Override
	public EinzelKeks create(Position p) {
		return new RundKeks(p.getTeigart());
	}

}
