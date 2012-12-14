/**
 * Ein Keks mit einer runden Form
 */
public class RundKeks extends Keks {
	public RundKeks(Teigart teig) {
		super(teig);
	}
	
	public String toString() {
		return "Form: Rund " + super.toString();
	}
}
