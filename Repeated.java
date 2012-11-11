/**
 * Repeated
 *
 * TODO: Beschreibung
 * 
 * @author TODO
 */
public class Repeated<P> extends AbstractPictArray<P> {
	private double factor;

	/**
	 * Setzt das Array und bestimmt den initialen Skalierungsfaktor.
	 *
	 * @param content Ein zweidimensionales, rechteckiges Array.
	 */
	public Repeated(P[][] content) {
		super(content);		
		factor = 1.0;
	}

	/**
	 * Ändert die Größe, ohne jedoch das Array zu verändern.
	 *
	 * @param factor Eine reelle Zahl größer 0.
	 */
	@Override
	public void scale(double factor) {
		this.factor *= factor;
	}
	
	public double getFactor() {
		return factor;
	}

	/**
	 * liefert eine charArray Repräsentation für den toString() Aufruf
	 */
	public char[][] getPrintArray(int[] maxWidth, int[] maxHeight) {
		return null;
	}
	
	/**
	 * TODO 
	 *
	 * Ist der durch (wiederholte) Aufrufe von scale gesetzte Skalierungsfaktor 
	 * kleiner 1.0, so liefert toString nur die entsprechend große linke obere 
	 * Ecke. Ist der Skalierungsfaktor größer als 1.0, so wird der Text 
	 * entsprechend oft neben- bzw. übereinander wiederholt.
	 */
	@Override
	public String toString() {
		// TODO
	 	return new String();
	}
}
