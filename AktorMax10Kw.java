
public class AktorMax10Kw extends Aktor {

	public AktorMax10Kw(int seriennummer) {
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
