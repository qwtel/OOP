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
public abstract class Traktor implements Identifiable {

	private static int seriennummer = 0;
	private final int nummer;
	private int betriebszeit;

	private Geraet geraet;
	
	public Traktor(Geraet geraet) {
		this.nummer = seriennummer++;
		this.geraet = geraet;
		betriebszeit = 0;
	}

	@Override
	public Integer id() {
		return nummer;
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
	public Number getZahl() {
		return geraet.getZahl();
	}

	@MethodAuthor(who="Florian Klampfer")
	Traktor getDieselTraktor() {
		return null;
	}

	@MethodAuthor(who="Florian Klampfer")
	Traktor getBiogasTraktor() {
		return null;
	}

	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDuengen() {
		return geraet.getTraktorDuengen(this);
	}

	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorSaeen() {
		return geraet.getTraktorSaeen(this);
	}
}
