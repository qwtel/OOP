/**
 * Ein Keks mit einer runden Form
 */
public class RundKeks extends EinzelKeks {
	public RundKeks(Teigart teig) {
		super(teig);
	}
	
	public String toString() {
		return "Form: Rund " + super.toString();
	}
}
