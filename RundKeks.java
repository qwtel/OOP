/**
 * Ein Keks mit einer runden Form
 */
public class RundKeks extends Keks {
	public RundKeks(Teigart teig) {
		super(teig);
	}
	
	public String toString() {
		return "Rund " + super.toString();
	}
}
