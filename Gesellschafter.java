
public class Gesellschafter extends Bediener {
	
	public Gesellschafter() {
		super();
	}

	public Gesellschafter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert2(RoboShop shop) {
		return software.fuerGesellschafter(shop, this);
	}
}
