
public class Objektbewacher extends Beschuetzer {
	
	public Objektbewacher() {
		super();
	}

	public Objektbewacher(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean checkSoftware(RoboShop shop) {
		return software.fuerObjektbewacher(shop, this);
	}
}
