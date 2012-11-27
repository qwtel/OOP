
public class Kaempfer extends Beschuetzer {
	
	public Kaempfer() {
		super();
	}

	public Kaempfer(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean checkSoftware(RoboShop shop) {
		return software.fuerKaempfer(shop, this);
	}
}
