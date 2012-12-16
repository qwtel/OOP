/**
 * Ein einfacher Keks ohne Fuellung.
 */
public abstract class EinzelKeks implements Keks {
	private Teigart teig;

	public EinzelKeks(Teigart teig) {
		this.teig = teig;
	}

	/**
	 * Kopierkonstruktor.
	 */
	public EinzelKeks(EinzelKeks keks) {
		this.teig = keks.teig;
	}

	/**
	 * @return Eine tiefe Kopie von diesem Keks.
	 */
	@Override
	abstract public Keks clone();

	@Override
	public String toString() {
		return "\nTeig: " + teig.toString();
	}
}
