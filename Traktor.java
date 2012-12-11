/**
 * Traktor ist eine Oberklasse von TraktorBioGas und TraktorDiesel.
 * Jeder Traktor hat eine unveraenderliche, eindeutige Nummer.
 * Jeder Traktor hat einen Einsatzzweck der durch sein Geraet bestimmt wird.
 * (GeraetDrill oder GeraetDuenger)
 * 
 * @author Michael Ion, Johannes Deml
 *
 */
@ClassAuthor(who="Johannes Deml, Michael Ion")
public abstract class Traktor implements Identifizierbar {

	private static int seriennummer = 0;
	private final int nummer;
	private int betriebszeit;

	private Geraet geraet;
	
	public Traktor(Geraet geraet) {
		this.nummer = seriennummer++;
		this.geraet = geraet;
		betriebszeit = 0;
	}

	/**
	 * Erhöht die betriebszeit um die spezifizierte Anzahl an Stunden.
	 * @param stunden die Ganzzahl um die die Arbeitszeit erhöht wird.
	 */
	@MethodAuthor(who = "Michael Ion")
	public void incStunden(int stunden) {
		betriebszeit += stunden;
	}

	/** 
	 * @return die Betriebszeit des Traktors
	 */
	@MethodAuthor(who = "Michael Ion")
	public int getBetriebszeit() {
		return betriebszeit;
	}

	/**
	 * Aendert das Geraet auf das neu erhaltene Geraet
	 * @param geraet Bedingung:Ein gueltiges Geraet
	 */
	@MethodAuthor(who = "Johannes Deml")
	public void setGeraet(Geraet geraet) {
		this.geraet = geraet;
	}

	/**
	 * @return Die Seriennummer des Traktors.
	 */
	@MethodAuthor(who="Florian Klampfer")
	@Override
	public Integer id() {
		return nummer;
	}

	/**
	 * @return Gibt den bisher verbrauchten Treibstoff zurueck
	 */
	@MethodAuthor(who = "Johannes Deml")
	public abstract Number getTreibstoffverbrauch();

	/**
	 * @param verbraucht Wird zum bisher verbrauchten Treibstoff dazugerechnet
	 */
	@MethodAuthor(who = "Johannes Deml")
	public abstract void incVerbrauchtenTreibstoff(Number verbraucht);

	@MethodAuthor(who="Florian Klampfer")
	public Number getAnzahl() {
		return geraet.getAnzahl();
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDiesel() {
		return null;
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorBiogas() {
		return null;
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDuengen() {
		return geraet.getTraktorDuengen(this);
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorSaeen() {
		return geraet.getTraktorSaeen(this);
	}
}
