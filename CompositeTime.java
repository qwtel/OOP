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

	/**
	 * Erzeugt eine neue CompositeTime und berechnet die Gesamtzeit.
	 *
	 * @param measures Ein Array das die Messwerte beinhaltet.
	 */
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
	 *
	 * @return Die Anzahl durchgeführter Messungen.
	 */
	@Override
	public int count() {
		return measures.length;
	}

	/**
	 * TODO: Implementierung.
	 *
	 * XXX: Sollte das vielleicht eine statische, generische Methode sein? Kommt
	 * im Skriptum vor. Testfälle genau anschaun, vielleicht finden sich da
	 * Hinweise darauf.
	 */
	public double getMinMeasure() {
		// TODO
		return 0.0;
	}
}
