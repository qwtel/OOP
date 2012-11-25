
public abstract class Bediener extends Android {

	public Bediener() {
		super();
	}

	public Bediener(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSkin(Skin skin) {
		skin.fuerBediener(this);
	}
}
