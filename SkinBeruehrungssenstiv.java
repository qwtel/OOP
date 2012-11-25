
public class SkinBeruehrungssenstiv extends Skin {
	
	/**
	 * Erzeugt eine Skin für den Androiden mit der spezifizierten Seriennummer.
	 *
	 * @param sn Die Seriennummer des Ziel-Androiden.
	 */
	public SkinBeruehrungssenstiv(int sn) {
		super(sn);
	}

	@Override
	public void fuerBediener(Bediener bediener) {
		bediener.setSkin(this);
	}

	@Override
	public void fuerSchwerarbeiter(Schwerarbeiter schwerarbeiter) {
		schwerarbeiter.setSkin(this);
	}

	@Override
	public void fuerBeschuetzer(Beschuetzer beschuetzer) {
		beschuetzer.setSkin(this);
	}

	@Override
	public String toString() {
		return "Berührungssensitiv";
	}
}
