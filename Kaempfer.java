
public class Kaempfer extends Beschuetzer {
	
	public Kaempfer(Skin skin, Software software) {
		super(skin);
		software.fuerKaempfer(this);
	}
}
