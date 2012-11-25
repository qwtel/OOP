
public class Leibwaechter extends Beschuetzer {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerLeibwaechter(this);
	}
}
