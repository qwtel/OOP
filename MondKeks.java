/**
 * Ein Keks in der Form eines Mondes.
 */
public class MondKeks extends EinzelKeks {
	public MondKeks(Teigart teig) {
		super(teig);
	}
	
	/**
	 * Kopierkonstruktor.
	 */
	public MondKeks(EinzelKeks keks) {
		super(keks);
	}

	/**
	 * @return Eine tiefe Kopie von diesem Keks.
	 */
	@Override
	public Keks clone() {
		return new MondKeks(this);
	}

	@Override
	public String toString() {
		return "Form: Mond " + super.toString();
	}
}
