/**
 * Eine Backmaschine, die MondKekse mit der spezifizierten Teigart herstellen
 */
public class MondKeksBackmaschine implements Backmaschine {

	@Override
	public Keks create(Teigart teig) {
		return new MondKeks(teig);
	}

}
