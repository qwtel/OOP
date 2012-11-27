
public abstract class Software {

	/**
	 * Die Seriennummer des Androiden für den diese Software bestimmt ist.
	 */
	private final int seriennummer;

	protected SoftwareStufe softwareStufe;
	
	/**
	 * Erzeugt eine neues Software Objekt für den Androiden mit der 
	 * spezifizierten Seriennummer.
	 *
	 * @param seriennummer Die Seriennummer des Ziel-Androiden.
	 */
	public Software(int seriennummer, SoftwareStufe softwareStufe) {
		this.seriennummer = seriennummer;
		this.softwareStufe = softwareStufe;
	}

	boolean fuerHilfskraft(RoboShop shop, Hilfskraft android) {
		return false;
	}

	boolean fuerGesellschafter(RoboShop shop, Gesellschafter android) {
		return false;
	}

	boolean fuerBauarbeiter(RoboShop shop, Bauarbeiter android) {
		return false;
	}

	boolean fuerServicetechniker(RoboShop shop, Servicetechniker android) {
		return false;
	}

	boolean fuerTransportarbeiter(RoboShop shop, Transportarbeiter android) {
		return false;
	}

	boolean fuerObjektbewacher(RoboShop shop, Objektbewacher android) {
		return false;
	}

	boolean fuerLeibwaechter(RoboShop shop, Leibwaechter android) {
		return false;
	}

	boolean fuerKaempfer(RoboShop shop, Kaempfer android) {
		return false;
	}
}
