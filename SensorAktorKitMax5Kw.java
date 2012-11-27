
public class SensorAktorKitMax5Kw extends SensorAktorKitMax10Kw {

	public SensorAktorKitMax5Kw(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean fuerStufe3(RoboShop shop, Android android) {
		return shop.otherInsert(android);
	}

	@Override
	public String toString() {
		return "max5kW";
	}
}
