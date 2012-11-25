
public class Transportarbeiter extends Schwerarbeiter {
	
	public Transportarbeiter() {
		super();
	}

	public Transportarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerTransportarbeiter(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerTransportarbeiter(this);
		
	}

}
