
public class SkinHochfest extends Skin {

	/**
	 * Erzeugt eine Skin für den Androiden mit der spezifizierten Seriennummer.
	 *
	 * @param sn Die Seriennummer des Ziel-Androiden.
	 */
	public SkinHochfest(int sn) {
		super(sn);
	}
	
	@Override
	boolean fuerSchwerarbeiter(RoboShop shop, Schwerarbeiter android) {
		return android.insert2(shop);
	}

	@Override
	boolean fuerBeschuetzer(RoboShop shop, Beschuetzer android) {
		return android.insert2(shop);
	}

	@Override
	public String toString() {
		return "HochFest";
	}
}