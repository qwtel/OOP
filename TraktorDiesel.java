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
	public Number getTreibstoffverbrauch() {
		return verbrauch;
	}
	
	@Override
	@MethodAuthor(who = "Michael Ion")
	public void erhoeheVerbrauchtenTreibstoff(Number verbraucht) {
		verbrauch += verbraucht.intValue();
	}
}
