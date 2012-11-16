/**
 * CompositeTime
 *
 * Stellt die Gesamtzeit eines aus mehreren Einzelzeiten zusammengesetzten 
 * Vorgangs dar. 
 *
 * Die Einzelzeiten werden in einer Instanz von Double[] abgelegt, wobei das 
 * Array im Konstruktor gesetzt wird. Für den Vergleich mit shorter wird die 
 * Summe der Einzelzeiten herangezogen, und count liefert die Länge des Arrays. 
 *
 * Eine Methode zur Ermittlung der kürzesten Einzelzeit ist nötig, aber andere 
 * Einzelzeiten sollen nicht abfragbar sein.
 *
 * @author TODO, Florian Klampfer
 */
public class CompositeTime extends ElapsedTime {

	private double[] measures;

	public CompositeTime(double[] measures) {
		this.measures = measures;

		double sum = 0.0;
		for(int i=0; i<measures.length; i++) {
        	sum += measures[i];
		}
		setTime(sum);
	}

	/**
	 * Liefert die Länge des Arrays.
	 */
	@Override
	public int count() {
		return measures.length;
	}

	/**
	 * TODO
	 */
	public double getMinMeasure() {
		// TODO
		return 0.0;
	}
}
