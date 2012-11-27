
public class AktorMax5Kw extends AktorMax10Kw {

	public AktorMax5Kw(int seriennummer) {
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
