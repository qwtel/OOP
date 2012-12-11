/**
 * TraktorDiesel hat eine Information über den momentanen Verbrauch des
 * Diesel-tanks. Dieser muss eine Ganzzahl sein.
 * @author Michael Ion
 *
 */
public class TraktorDiesel extends Traktor {
	int verbrauch;

	public TraktorDiesel(Geraet geraet) {
		super(geraet);
		verbrauch = 0;
	}

	@Override
	@MethodAuthor(who = "Michael Ion")
	public Integer getTreibstoffverbrauch() {
		return verbrauch;
	}
	
	@Override
	@MethodAuthor(who = "Michael Ion")
	public void incVerbrauchtenTreibstoff(Number verbraucht) {
		verbrauch += verbraucht.intValue();
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDiesel() {
		return this;
	}
}
