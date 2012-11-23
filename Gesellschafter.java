
public class Gesellschafter extends Bediener {
	
	public Gesellschafter(Skin skin, Software software) {
		super(skin);
		software.fuerGesellschafter(this);
	}
}
