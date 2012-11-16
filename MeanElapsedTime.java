/**
 * MeanElapsedTime
 *
 * Stellt die durchschnittliche Zeit einer Messreihe dar. 
 *
 * Die einzelnen Zeiten in der Messreihe werden in einem (nach außen nicht 
 * sichtbaren) Objekt des Typs Set<Double> abgelegt. Für den Vergleich mit 
 * shorter wird der Durchschnittswert herangezogen, und count liefert die Anzahl
 * der Messungen. 
 *
 * Methoden zum Hinzufügen weiterer Messwerte sowie zur Ermittlung des größten 
 * Messwerts sind nötig. Andere Messwerte sollen nicht direkt abfragbar sein.
 *
 * @author TODO, Florian Klampfer
 */
public class MeanElapsedTime extends ElapsedTime {

	private Set<Double> measures;
	private int count;

	/**
	 * Erzeugt eine neue MeanElapsedTime.
	 *
	 * @param measures Ein Array das die Messwerte beinhaltet.
	 */
	public MeanElapsedTime() {
		measures = new Set<Double>();
		count = 0;
	}

	/**
	 * Liefert die Anzahl durch add hinzugefügter Messungen.
	 *
	 * @return Die Anzahl durchgeführter Messungen.
	 */
	@Override
	public int count() {
		return count;
	}

	/**
	 * Fügt eine Messung hinzu und berechnet den Durchschnittswert neu.
	 *
	 * @param measue Der neue Messert.
	 */
	public void add(double measure) {
    	measures.insert(measure);
		count++;

		double sum = 0.0;
		for(double d : measures) {
			sum += d;
		}
		setTime(sum/count);
	}

	/**
	 * TODO: Implementierung.
	 *
	 * XXX: Sollte das vielleicht eine statische, generische Methode sein? Kommt
	 * im Skriptum vor. Testfälle genau anschaun, vielleicht finden sich da
	 * Hinweise darauf.
	 */
	public double getMaxMeasure() {
		// TODO
		return 0.0;
	}
}
