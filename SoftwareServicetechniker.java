
public class SoftwareServicetechniker extends Software {

	public SoftwareServicetechniker (int s) {
		super(s);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fuerBauarbeiter(Bauarbeiter bauarbeiter) {
		bauarbeiter.setSoftware(null);

	}

	@Override
	public void fuerServicetechniker(Servicetechniker servicetechniker) {
		servicetechniker.setSoftware(this);
	}

	@Override
	public void fuerTransportarbeiter(Transportarbeiter transportarbeiter) {
		transportarbeiter.setSoftware(null);
	}

	@Override
	public void fuerHilfskraft(Hilfskraft hilfskraft) {
		hilfskraft.setSoftware(null);
	}

	@Override
	public void fuerGesellschafter(Gesellschafter gesellschafter) {
		gesellschafter.setSoftware(null);
	}

	@Override
	public void fuerObjektbewacher(Objektbewacher objektbewacher) {
		objektbewacher.setSoftware(null);
	}

	@Override
	public void fuerLeibwaechter(Leibwaechter leibwaechter) {
		leibwaechter.setSoftware(null);
	}

	@Override
	public void fuerKaempfer(Kaempfer kaempfer) {
		kaempfer.setSoftware(null);
	}

}
