
public abstract class Software {
	private int seriennummer;
	private SoftwareStufe softwareStufe;
	
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

	public SoftwareStufe getSoftwareStufe() {
		return softwareStufe;
	}

	public void setSoftwareStufe(SoftwareStufe softwareStufe) {
		this.softwareStufe = softwareStufe;
	}
	
	
}
