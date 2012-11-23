
public class SkinHochfest extends Skin {

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
