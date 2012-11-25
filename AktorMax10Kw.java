
public class AktorMax10Kw extends Aktor {

	public AktorMax10Kw(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void fuerBauarbeiter(Bauarbeiter bauarbeiter) {
		bauarbeiter.setAktor(this);

	}

	@Override
	public void fuerServicetechniker(Servicetechniker servicetechniker) {
		servicetechniker.setAktor(this);

	}

	@Override
	public void fuerTransportarbeiter(Transportarbeiter transportarbeiter) {
		transportarbeiter.setAktor(this);
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
		objektbewacher.setAktor(this);

	}

	@Override
	public void fuerLeibwaechter(Leibwaechter leibwaechter) {
		leibwaechter.setAktor(this);

	}

	@Override
	public void fuerKaempfer(Kaempfer kaempfer) {
		kaempfer.setAktor(null);

	}

	@Override
	public String toString() {
		return "max10kW";
	}

}
