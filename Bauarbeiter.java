
public class Bauarbeiter extends Schwerarbeiter {

	@Override
	public void installSoftware(Software software) {
		software.fuerBauarbeiter(this);
	}
}
