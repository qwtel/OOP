
public class SoftwareLeibwaechter extends Software {

	public SoftwareLeibwaechter(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}
	
	@Override
	boolean fuerLeibwaechter(RoboShop shop, Leibwaechter android) {
		return softwareStufe.fuerLeibwaechter(shop, android);
	}
}
