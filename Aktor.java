
public abstract class Aktor {

	/**
	 * Die Seriennummer des Androiden für den diese Software bestimmt ist.
	 */
	private final int seriennummer;
	
	/**
	 * Erzeugt eine neues Aktoren Objekt für den Androiden mit der 
	 * spezifizierten Seriennummer.
	 *
	 * @param seriennummer Die Seriennummer des Ziel-Androiden.
	 */
	public Aktor(int seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	public abstract void fuerBauarbeiter(Bauarbeiter bauarbeiter);
	public abstract void fuerServicetechniker(Servicetechniker servicetechniker);
	public abstract void fuerTransportarbeiter(Transportarbeiter transportarbeiter);
	
	public abstract void fuerHilfskraft(Hilfskraft hilfskraft);
	public abstract void fuerGesellschafter(Gesellschafter gesellschafter);
	
	public abstract void fuerObjektbewacher(Objektbewacher objektbewacher);
	public abstract void fuerLeibwaechter(Leibwaechter leibwaechter);
	public abstract void fuerKaempfer(Kaempfer kaempfer);


	@Override
	public abstract String toString();
}
