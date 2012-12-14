/**
 * Eine Backmaschine, die WeihnachstmannKekse mit der spezifizierten Teigart herstellen
 */
public class WeihnachtsmannKeksBackmaschine implements Backmaschine {

	@Override
	public Keks create(Teigart teig) {
		return new WeihnachtsmannKeks(teig);
	}

}
