
public class SoftwareHilfskraft extends Software {

	public SoftwareHilfskraft(int s, SoftwareStufe softwareStufe) { 
		super(s, softwareStufe);
	}

	@Override
	boolean fuerHilfskraft(RoboShop shop, Hilfskraft android) {
		return softwareStufe.fuerHilfskraft(shop, android);
	}
}
