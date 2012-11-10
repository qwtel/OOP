/**
 * AbstractPictArray
 *
 * TODO: Beschreibung
 * 
 * @author mihi
 */
public abstract class AbstractPictArray<P> implements Pict {
	private final P[][] content;

	/**
	 * Setzt das Array.
	 *
	 * @param content Ein nichtleeres, zweidimensionales, rechteckiges Array.
	 */
	public AbstractPictArray(P[][] content) {
		this.content = content;			
	}
	
	@Override
	abstract public void scale(double factor);
			
	/**
	 * Gibt die Elemente des Arrays nebeneinander und übereinander liegend 
	 * zurück. (genauer gesagt die Ergebnisse der Aufrufe von toString in den 
	 * Elementen). 
	 *
	 * Haben die Elemente unterschiedliche Höhe bzw. Breite, werden die 
	 * kleineren Elemente unterhalb bzw. rechts mit Leerzeichen aufgefüllt.
	 */
	@Override
	public String toString() {
		// TODO
		for(int h=0; h<content.length; h++) {
			for(int w=0; w<content[0].length; w++) {
			}
		}
		// TODO
	 	return new String();
	}

	@Override
	public boolean equals(Object o) {
		// TODO
	 	return false;
	}
}
