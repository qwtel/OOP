
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
	public void fuerBediener(Bediener bediener) {
		bediener.setSkin(null);
	}

	@Override
	public void fuerSchwerarbeiter(Schwerarbeiter schwerarbeiter) {
		schwerarbeiter.setSkin(this);
	}

	@Override
	public void fuerBeschuetzer(Beschuetzer beschuetzer) {
		beschuetzer.setSkin(this);
	}

}
