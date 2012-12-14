/**
 * Eine Backmaschine, die WeihnachstmannKekse mit der spezifizierten Teigart herstellen
 */
public class WeihnachtsmannKeksBackmaschine implements Backmaschine {

	@Override
	public EinzelKeks create(Position p) {
		return new WeihnachtsmannKeks(p.getTeigart());
	}

}
