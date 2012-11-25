
public class Hilfskraft extends Bediener {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerHilfskraft(this);
	}
}
