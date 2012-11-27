
public abstract class Skin {

	/**
	 * Die Seriennummer des Androiden für den diese Skin gefertigt wurde.
	 */
	private final int seriennummer;

	/**
	 * Erzeugt eine Skin für den Androiden mit der spezifizierten Seriennummer.
	 *
	 * @param seriennummer Die Seriennummer des Ziel-Androiden.
	 */
	public Skin(int seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	boolean fuerBediener(RoboShop shop, Bediener android) {
		return false;
	}

	boolean fuerSchwerarbeiter(RoboShop shop, Schwerarbeiter android) {
		return false;
	}

	boolean fuerBeschuetzer(RoboShop shop, Beschuetzer android) {
		return false;
	}

	@Override
	public abstract String toString();
}
