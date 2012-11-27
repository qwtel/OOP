
public class Leibwaechter extends Beschuetzer {
	
	public Leibwaechter() {
		super();
	}

	public Leibwaechter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert2(RoboShop shop) {
		return software.fuerLeibwaechter(shop, this);
	}
}
