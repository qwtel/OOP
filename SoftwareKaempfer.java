
public class SoftwareKaempfer extends Software {

	public SoftwareKaempfer(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}

	@Override
	boolean fuerKaempfer(RoboShop shop, Kaempfer android) {
		return softwareStufe.fuerKaempfer(shop, android);
	}
}
