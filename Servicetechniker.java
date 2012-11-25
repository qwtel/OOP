
public class Servicetechniker extends Schwerarbeiter {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerServicetechniker(this);
	}
}
