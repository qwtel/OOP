/**
 *
 */
public abstract class Keks {
	private Teigart teig;

	public Keks(Teigart teig) {
		this.teig = teig;
	}
	
	public String toString() {
		return " " + teig.toString() + " \n";
	}
}
