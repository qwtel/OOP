/**
 * Ein Keks mit einer runden Form.
 */
public class RundKeks extends EinzelKeks {
	public RundKeks(Teigart teig) {
		super(teig);
	}

	/**
	 * Kopierkonstruktor.
	 */
	public RundKeks(EinzelKeks keks) {
		super(keks);
	}
	
	/**
	 * @return Eine tiefe Kopie von diesem Keks.
	 */
	@Override
	public Keks clone() {
		return new RundKeks(this);
	}

	@Override
	public String toString() {
		return "Form: Rund " + super.toString();
	}
}
