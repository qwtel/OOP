/**
 * Ein Keks in der Form des Weihnachtsmanns
 */
public class WeihnachtsmannKeks extends Keks {
	public WeihnachtsmannKeks(Teigart teig) {
		super(teig);
	}
	
	public String toString() {
		return "Form: Weihnachtsmann " + super.toString();
	}
}
