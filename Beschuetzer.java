
public abstract class Beschuetzer extends Android {

	@Override
	public void installSkin(Skin skin) {
		skin.fuerBeschuetzer(this);
	}
}
