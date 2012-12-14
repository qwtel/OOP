/**
 * Ein Keks in der Form des Weihnachtsmanns.
 */
public class WeihnachtsmannKeks extends EinzelKeks {
	public WeihnachtsmannKeks(Teigart teig) {
		super(teig);
	}

	/**
	 * Kopierkonstruktor.
	 */
	public WeihnachtsmannKeks(EinzelKeks keks) {
		super(keks);
	}

	/**
	 * @return Eine tiefe Kopie von diesem Keks.
	 */
	@Override
	public Keks clone() {
		return new WeihnachtsmannKeks(this);
	}
	
	@Override
	public String toString() {
		return "Form: Weihnachtsmann " + super.toString();
	}
}
