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
public abstract class Traktor {

	private static int seriennummer = 0;
	private final int nummer;
	private int betriebszeit;

	protected Geraet geraet;
	
	public Traktor(Geraet geraet) {
		this.nummer = seriennummer++;
		this.geraet = geraet;
		betriebszeit = 0;
	}
	
	@MethodAuthor(who = "Michael Ion")
	public void erhoeheStunden(int stunden) {
		betriebszeit += stunden;
	}

	@MethodAuthor(who = "Michael Ion")
	public int getBetriebszeit() {
		return betriebszeit;
	}

	@MethodAuthor(who = "Johannes Deml")
	public void setGeraet(Geraet geraet) {
		this.geraet = geraet;
	}

	@MethodAuthor(who = "Johannes Deml")
	public abstract Number getTreibstoffverbrauch();

	@MethodAuthor(who = "Johannes Deml")
	public abstract void erhoeheVerbrauchtenTreibstoff(Number verbraucht);

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitDuengen() {
		return geraet.getBetriebszeitDuengen(this);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitSaeen() {
		return geraet.getBetriebszeitSaeen(this);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitBiogas() {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitDiesel() {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauch() {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchDuengen() {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchSaeen() {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauch() {
		return new Tupel(.0f, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchDuengen() {
		return new Tupel(.0f, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchSaeen() {
		return new Tupel(.0f, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	int getSaescharen() {
		return geraet.getSaescharen();
	}

	@MethodAuthor(who="Florian Klampfer")
	int getSaescharenDiesel() {
		return 0;
	}

	@MethodAuthor(who="Florian Klampfer")
	int getSaescharenBiogas() {
		return 0;
	}

	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaet() {
		return geraet.getKapazitaet();
	}

	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaetDiesel() {
		return 0;
	}

	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaetBiogas() {
		return 0;
	}
}
