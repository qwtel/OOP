
public class Servicetechniker extends Schwerarbeiter {
	
	public Servicetechniker(Skin skin, Software software) {
		super(skin);
		software.fuerServicetechniker(this);
	}
}
