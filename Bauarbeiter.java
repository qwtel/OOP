
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter() {
		super();
	}

	public Bauarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert2(RoboShop shop) {
		return software.fuerBauarbeiter(shop, this);
	}
}
