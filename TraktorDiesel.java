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

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitDiesel() {
		return new Tupel(getBetriebszeit(), 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauch() {
		return new Tupel(verbrauch, 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchDuengen() {
		return geraet.getDieselVerbrauchDuengen(this);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchSaeen() {
		return geraet.getDieselVerbrauchSaeen(this);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	int getSaescharenDiesel() {
		return geraet.getSaescharen();
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaetDiesel() {
		return geraet.getKapazitaet();
	}
}
