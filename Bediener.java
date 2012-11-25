
public abstract class Bediener extends Android {

	@Override
	public void installSkin(Skin skin) {
		skin.fuerBediener(this);
	}
}
