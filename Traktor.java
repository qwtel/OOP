
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
	private Geraet geraet;
	private int betriebszeit;
	
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

}