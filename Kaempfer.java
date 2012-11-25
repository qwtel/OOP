
public class Kaempfer extends Beschuetzer {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerKaempfer(this);
	}
}
