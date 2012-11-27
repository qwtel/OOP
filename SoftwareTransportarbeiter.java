
public class SoftwareTransportarbeiter extends Software {

	public SoftwareTransportarbeiter(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}
		
	@Override
	boolean fuerTransportarbeiter(RoboShop shop, Transportarbeiter android) {
		return softwareStufe.fuerTransportarbeiter(shop, android);
	}
}
