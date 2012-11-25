
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
	
	public abstract void fuerBediener(Bediener bediener);
	
	public abstract void fuerSchwerarbeiter(Schwerarbeiter schwerarbeiter);
	
	public abstract void fuerBeschuetzer(Beschuetzer beschuetzer);
}
