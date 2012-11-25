
public abstract class Software {

	/**
	 * Die Seriennummer des Androiden für den diese Software bestimmt ist.
	 */
	private final int seriennummer;

	private SoftwareStufe softwareStufe;
	
	/**
	 * Erzeugt eine neues Software Objekt für den Androiden mit der 
	 * spezifizierten Seriennummer.
	 *
	 * @param seriennummer Die Seriennummer des Ziel-Androiden.
	 */
	public Software(int seriennummer) {
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

	public void setSoftwareStufe(SoftwareStufe softwareStufe) {
		this.softwareStufe = softwareStufe;
	}

	public SoftwareStufe getSoftwareStufe() {
		return softwareStufe;
	}
}
