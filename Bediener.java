
public abstract class Bediener extends Android {

	public Bediener() {
		super();
	}

	public Bediener(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert(RoboShop shop) {
		return skin.fuerBediener(shop, this);
	}
}
