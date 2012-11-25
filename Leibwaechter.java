
public class Leibwaechter extends Beschuetzer {
	
	public Leibwaechter() {
		super();
	}

	public Leibwaechter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerLeibwaechter(this);
	}

	@Override
	public void installAktor(Aktor aktor) {
		aktor.fuerLeibwaechter(this);	
	}
}
