/**
 * TraktorBioGas hat eine Information über den momentanen Verbrauch des 
 * BioGas-Tanks.
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

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitBiogas() {
		return new Tupel(getBetriebszeit(), 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauch() {
		return new Tupel(verbrauch, 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	int getSaescharenBiogas() {
		return geraet.getSaescharen();
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaetDiesel() {
		return geraet.getKapazitaet();
	}
}
