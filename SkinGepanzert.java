
public class SkinGepanzert extends Skin {

	/**
	 * Erzeugt eine Skin für den Androiden mit der spezifizierten Seriennummer.
	 *
	 * @param sn Die Seriennummer des Ziel-Androiden.
	 */
	public SkinGepanzert(int sn) {
		super(sn);
	}

	@Override
	boolean fuerBeschuetzer(RoboShop shop, Beschuetzer android) {
		return android.insert2(shop);
	}

	@Override
	public String toString() {
		return "Gepanzert";
	}
}
