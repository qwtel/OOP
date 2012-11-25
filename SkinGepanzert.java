
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
	public void fuerBediener(Bediener bediener) {
		bediener.setSkin(null);
	}

	@Override
	public void fuerSchwerarbeiter(Schwerarbeiter schwerarbeiter) {
		schwerarbeiter.setSkin(null);
	}

	@Override
	public void fuerBeschuetzer(Beschuetzer beschuetzer) {
		beschuetzer.setSkin(this);
	}

	@Override
	public String toString() {
		return "Gepanzert";
	}
}
