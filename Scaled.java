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
   		// TODO
	}
}
