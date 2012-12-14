/**
 * Ein Keks in der Form des Weihnachtsmanns
 */
public class WeihnachtsmannKeks extends EinzelKeks {
	public WeihnachtsmannKeks(Teigart teig) {
		super(teig);
	}
	
	@Override
	public String toString() {
		return "Form: Weihnachtsmann " + super.toString();
	}
}
