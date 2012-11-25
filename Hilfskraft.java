
public class Hilfskraft extends Bediener {
	
	public Hilfskraft() {
		super();
	}

	public Hilfskraft(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerHilfskraft(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerHilfskraft(this);
	}
}
