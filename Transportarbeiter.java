
public class Transportarbeiter extends Schwerarbeiter {
	
	public Transportarbeiter() {
		super();
	}

	public Transportarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean checkSoftware(RoboShop shop) {
		return software.fuerTransportarbeiter(shop, this);
	}
}
