
public class SensorAktorKitMax10Kw extends SensorAktorKit {

	public SensorAktorKitMax10Kw(int seriennummer) {
		super(seriennummer);
	}

	@Override
	boolean fuerStufe4(RoboShop shop, Android android) {
		return shop.otherInsert(android);
	}

	@Override
	public String toString() {
		return "max10kW";
	}
}
