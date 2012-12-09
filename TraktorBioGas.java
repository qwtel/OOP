
public class TraktorBioGas extends Traktor {
	float verbrauch;
	public TraktorBioGas(Geraet geraet) {
		super(geraet);
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
