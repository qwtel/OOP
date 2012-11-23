
public class SkinBeruehrungssenstiv extends Skin{

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

}
