
public class Objektbewacher extends Beschuetzer {
	
	public Objektbewacher() {
		super();
	}

	public Objektbewacher(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean insert2(RoboShop shop) {
		return software.fuerObjektbewacher(shop, this);
	}
}
