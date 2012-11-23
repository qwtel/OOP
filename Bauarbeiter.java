
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(Skin skin, Software software) {
		super(skin);
		software.fuerBauarbeiter(this);
	}

}
