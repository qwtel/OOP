
public class Servicetechniker extends Schwerarbeiter {
	
	public Servicetechniker() {
		super();
	}

	public Servicetechniker(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean checkSoftware(RoboShop shop) {
		return software.fuerServicetechniker(shop, this);
	}
}
