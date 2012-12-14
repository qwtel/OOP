/**
 *
 */
public abstract class EinzelKeks implements Keks {
	private Teigart teig;

	public EinzelKeks() {
		this.teig = null;
	}
	
	public EinzelKeks(Teigart teig) {
		this.teig = teig;
	}
	
	@Override
	public String toString() {
		return "\nTeig: " + teig.toString();
	}
}
