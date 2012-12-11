/**
 * TraktorBioGas hat eine Information über den momentanen Verbrauch des 
 * BioGas-Tanks.
 * Dieser Wert muss eine Gleitkommazahl sein.
 * @author Michael Ion
 *
 */
public class TraktorBiogas extends Traktor {
	float verbrauch;
	public TraktorBiogas(Geraet geraet) {
		super(geraet);
		verbrauch = 0;
	}
	
	@Override
	@MethodAuthor(who = "Michael Ion")
	public Float getTreibstoffverbrauch() {
		return verbrauch;
	}
	
	@Override
	@MethodAuthor(who = "Michael Ion")
	public void incVerbrauchtenTreibstoff(Number verbraucht) {
		verbrauch += verbraucht.floatValue();
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorBiogas() {
		return this;
	}
}
