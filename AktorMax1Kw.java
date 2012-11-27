
public class AktorMax1Kw extends AktorMax5Kw {

	public AktorMax1Kw(int seriennummer) {
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
