
public class SensorAktorKitMax1Kw extends SensorAktorKitMax5Kw {

	public SensorAktorKitMax1Kw(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean fuerBediener(RoboShop shop, Bediener android) {
		shop.ship(android);
		return true;
	}
	
	@Override
	public String toString() {
		return "max1kW";
	}

}
