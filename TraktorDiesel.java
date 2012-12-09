
public class TraktorDiesel extends Traktor {
	int verbrauch;
	public TraktorDiesel(int nummer, Geraet geraet) {
		super(nummer, geraet);
		verbrauch = 0;
	}
	@Override
	public Number getTreibstoffverbrauch() {
		return verbrauch;
	}
	@Override
	public void erhoeheVerbrauchtenTreibstoff(Number verbraucht) {
		verbrauch += verbraucht.intValue();
	}
}
