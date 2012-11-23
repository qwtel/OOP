
public class Transportarbeiter extends Schwerarbeiter {
	
	public Transportarbeiter(Skin skin, Software software) {
		super(skin);
		software.fuerTransportarbeiter(this);
	}
}
