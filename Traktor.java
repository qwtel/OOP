
/**
 * Traktor ist eine Oberklasse von TraktorBioGas und TraktorDiesel.
 * Jeder Traktor hat eine unveraenderliche, eindeutige Nummer.
 * Jeder Traktor hat einen Einsatzzweck der durch sein Geraet bestimmt wird.
 * (GeraetDrill oder GeraetDuenger)
 * 
 * @author Michael Ion, Johannes Deml
 *
 */

public abstract class Traktor {

	private static int seriennummer = 0;
	private final int nummer;
	Geraet geraet; //XXX: getter method?
	private int betriebszeit;
	
	public Traktor(Geraet geraet) {
		this.nummer = seriennummer++;
		this.geraet = geraet;
		betriebszeit = 0;
	}
	
	public void erhoeheStunden(int stunden) {
		betriebszeit += stunden;
	}
	
	public int getBetriebszeit() {
		return betriebszeit;
	}
	
	public void setGeraet(Geraet geraet) {
		this.geraet = geraet;
	}

	public abstract Number getTreibstoffverbrauch();
	public abstract void erhoeheVerbrauchtenTreibstoff(Number verbraucht);
}
