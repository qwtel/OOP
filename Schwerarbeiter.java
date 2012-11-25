
public abstract class Schwerarbeiter extends Android {

	public Schwerarbeiter() {
		super();
	}

	public Schwerarbeiter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSkin(Skin skin) {
		skin.fuerSchwerarbeiter(this);
	}
}
