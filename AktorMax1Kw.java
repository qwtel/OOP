
public class AktorMax1Kw extends Aktor {

	public AktorMax1Kw(int seriennummer) {
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
		hilfskraft.setAktor(this);

	}

	@Override
	public void fuerGesellschafter(Gesellschafter gesellschafter) {
		gesellschafter.setAktor(this);

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
		kaempfer.setAktor(null);

	}

	@Override
	public String toString() {
		return "max1kW";
	}

}
