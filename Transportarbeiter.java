
public class Transportarbeiter extends Schwerarbeiter {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerTransportarbeiter(this);
	}
}
