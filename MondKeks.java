/**
 * Ein Keks in der Form eines Mondes
 */
public class MondKeks extends Keks{
	public MondKeks(Teigart teig) {
		super(teig);
	}
	
	public String toString() {
		return "Mond " + super.toString();
	}
}
