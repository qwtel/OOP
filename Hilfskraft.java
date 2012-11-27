
public class Hilfskraft extends Bediener {
	
	public Hilfskraft() {
		super();
	}

	public Hilfskraft(int seriennummer) {
		super(seriennummer);
	}

	@Override
    boolean checkSoftware(RoboShop shop) {
        return software.fuerHilfskraft(shop, this);
    }
}
