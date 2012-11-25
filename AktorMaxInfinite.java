
public class AktorMaxInfinite extends Aktor {

	public AktorMaxInfinite(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void fuerBauarbeiter(Bauarbeiter bauarbeiter) {
		bauarbeiter.setAktor(null);

	}

	@Override
	public void fuerServicetechniker(Servicetechniker servicetechniker) {
		servicetechniker.setAktor(null);

	}

	@Override
	public void fuerTransportarbeiter(Transportarbeiter transportarbeiter) {
		transportarbeiter.setAktor(null);
	}

	@Override
	public void fuerHilfskraft(Hilfskraft hilfskraft) {
		hilfskraft.setAktor(null);

	}

	@Override
	public void fuerGesellschafter(Gesellschafter gesellschafter) {
		gesellschafter.setAktor(null);

	}

	@Override
	public void fuerObjektbewacher(Objektbewacher objektbewacher) {
		objektbewacher.setAktor(null);

	}

	@Override
	public void fuerLeibwaechter(Leibwaechter leibwaechter) {
		leibwaechter.setAktor(null);

	}

	@Override
	public void fuerKaempfer(Kaempfer kaempfer) {
		kaempfer.setAktor(this);

	}

	@Override
	public String toString() {
		return "maxInfinite";
	}

}
