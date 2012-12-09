
public abstract class Traktor {

	private final int nummer;
	private Geraet geraet;
	private int betriebszeit;
	
	public Traktor(int nummer, Geraet geraet) {
		this.nummer = nummer;
		this.geraet = geraet;
		betriebszeit = 0;
	}
	
	public void erhoeheStunden(int stunden) {
		betriebszeit += stunden;
	}
	
	public int getBetriebszeit() {
		return betriebszeit;
	}

}