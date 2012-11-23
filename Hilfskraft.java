
public class Hilfskraft extends Bediener {
	
	public Hilfskraft(Skin skin, Software software) {
		super(skin);
		software.fuerHilfskraft(this);
	}
}
