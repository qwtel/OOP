
public abstract class Software {
	private int s;
	
	
	public Software(int s) {
		this.s = s;
	}
	
	public abstract void fuerBauarbeiter(Bauarbeiter bauarbeiter);
	public abstract void fuerServicetechniker(Servicetechniker servicetechniker);
	public abstract void fuerTransportarbeiter(Transportarbeiter transportarbeiter);
	
	public abstract void fuerHilfskraft(Hilfskraft hilfskraft);
	public abstract void fuerGesellschafter(Gesellschafter gesellschafter);
	
	public abstract void fuerObjektbewacher(Objektbewacher objektbewacher);
	public abstract void fuerLeibwaechter(Leibwaechter leibwaechter);
	public abstract void fuerKaempfer(Kaempfer kaempfer);
}
