
public class TraktorBioGas extends Traktor {
	float verbrauch;
	public TraktorBioGas(int nummer, Geraet geraet) {
		super(nummer, geraet);
		verbrauch = 0;
	}
	@Override
	public Number getTreibstoffverbrauch() {
		return verbrauch;
	}
	@Override
	public void erhoeheVerbrauchtenTreibstoff(Number verbraucht) {
		verbrauch+=verbraucht.floatValue();
		
	}

}
