
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter() {
		super();
	}

	public Bauarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerBauarbeiter(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerBauarbeiter(this);
		
	}
}
