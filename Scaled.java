/**
 * Scaled
 *
 * TODO: Beschreibung
 * 
 * @author TODO
 */
public class Scaled<P extends Pict> extends AbstractPictArray<P> {
	/**
	 * Setzt das Array.
	 *
	 * @param content Ein zweidimensionales, rechteckiges Array.
	 */
	public Scaled(P[][] content) {
		super(content);		
	}

	/**
	 * Jeder Aufruf von scale wird mit demselben Argument direkt an die 
	 * einzelnen Elemente des Arrays weitergeleitet. 
	 */
	@Override
	public void scale(double factor) {
		int width = getContent().length;
		int height = getContent()[0].length;
		for (int h=0; h<height; h++) {
			for(int w=0; w<width; w++) {
				getContent()[w][h].scale(factor);
			}
		}
	}
	
	/**
	 * liefert eine charArray Repräsentation für den toString() Aufruf
	 */
	public char[][] getPrintArray(int[] maxWidth, int[] maxHeight) {
		return null;
	}
	
	public double getFactor() {
		return 1.0;
	}
}
