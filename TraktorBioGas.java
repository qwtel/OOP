/**
 * TraktorBioGas hat eine Information über den momentanen Verbrauch des BioGas-Tanks.
 * Dieser Wert muss eine Gleitkommazahl sein.
 * @author Michael Ion
 *
 */
public class TraktorBioGas extends Traktor {
	float verbrauch;
	public TraktorBioGas(Geraet geraet) {
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
		verbrauch+=verbraucht.floatValue();
		
	}

}
