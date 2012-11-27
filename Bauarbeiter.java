
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter() {
		super();
	}

	public Bauarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean checkSoftware(RoboShop shop) {
		return software.fuerBauarbeiter(shop, this);
	}
}
