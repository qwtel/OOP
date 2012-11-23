
public class SoftwareLeibwaechter extends Software {

	public SoftwareLeibwaechter(int s, SoftwareStufe softwareStufe) {
		super(s);
		softwareStufe.fuerSoftwareLeibwaechter(this);
	}

	@Override
	public void fuerBauarbeiter(Bauarbeiter bauarbeiter) {
		bauarbeiter.setSoftware(null);

	}

	@Override
	public void fuerServicetechniker(Servicetechniker servicetechniker) {
		servicetechniker.setSoftware(null);
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
		leibwaechter.setSoftware(this);
	}

	@Override
	public void fuerKaempfer(Kaempfer kaempfer) {
		kaempfer.setSoftware(null);
	}

}
