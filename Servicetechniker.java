
public class Servicetechniker extends Schwerarbeiter {
	
	public Servicetechniker() {
		super();
	}

	public Servicetechniker(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerServicetechniker(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerServicetechniker(this);
		
	}
	
}
