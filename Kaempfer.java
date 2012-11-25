
public class Kaempfer extends Beschuetzer {
	
	public Kaempfer() {
		super();
	}

	public Kaempfer(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerKaempfer(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerKaempfer(this);
		
	}
}
