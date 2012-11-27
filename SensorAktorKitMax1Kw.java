
public class SensorAktorKitMax1Kw extends SensorAktorKitMax5Kw {

	public SensorAktorKitMax1Kw(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean fuerBediener(RoboShop shop, Bediener android) {
		return shop.otherInsert(android);
	}
	
	@Override
	public String toString() {
		return "max1kW";
	}

}
