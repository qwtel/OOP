
public class SensorAktorKit {

	/**
	 * Die Seriennummer des Androiden für den dieser Aktor bestimmt ist.
	 */
	private final int seriennummer;
	
	/**
	 * Erzeugt eine neues Aktoren Objekt für den Androiden mit der 
	 * spezifizierten Seriennummer.
	 *
	 * @param seriennummer Die Seriennummer des Ziel-Androiden.
	 */
	public SensorAktorKit(int seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	boolean fuerBediener(RoboShop shop, Bediener android) {
		return false;
	}
	
	boolean fuerStufe3(RoboShop shop, Android android) {
		return false;
	}
	
	boolean fuerStufe4(RoboShop shop, Android android) {
		return false;
	}
	
	boolean fuerKaempfer(RoboShop shop, Kaempfer android) {
		shop.ship(android);
		return true;
	}

	@Override
	public String toString() {
		return "maxInf";
	}
}