
public abstract class Schwerarbeiter extends Android {

	public Schwerarbeiter() {
		super();
	}

	public Schwerarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert(RoboShop shop) {
		return skin.fuerSchwerarbeiter(shop, this);
	}
}
