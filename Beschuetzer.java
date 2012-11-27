
public abstract class Beschuetzer extends Android {

	public Beschuetzer() {
		super();
	}

	public Beschuetzer(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert(RoboShop shop) {
		return skin.fuerBeschuetzer(shop, this);
	}
}
