/**
 * Eine Backmaschine, die RundKekse mit der spezifizierten Teigart herstellen
 */
public class RundKeksBackmaschine implements Backmaschine {

	@Override
	public Keks create(Teigart teig) {
		return new RundKeks(teig);
	}

}
