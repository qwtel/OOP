/**
 * Ein Keks in der Form eines Mondes
 */
public class MondKeks extends EinzelKeks{
	public MondKeks(Teigart teig) {
		super(teig);
	}
	
	@Override
	public String toString() {
		return "Form: Mond " + super.toString();
	}
}
