
public abstract class Beschuetzer extends Android {

	public Beschuetzer() {
		super();
	}

	public Beschuetzer(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSkin(Skin skin) {
		skin.fuerBeschuetzer(this);
	}
}
