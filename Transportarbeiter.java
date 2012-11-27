
public class Transportarbeiter extends Schwerarbeiter {
	
	public Transportarbeiter() {
		super();
	}

	public Transportarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert2(RoboShop shop) {
		return software.fuerTransportarbeiter(shop, this);
	}
}
