
public class SoftwareServicetechniker extends Software {
	
	public SoftwareServicetechniker (int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}
		
	@Override
	boolean fuerServicetechniker(RoboShop shop, Servicetechniker android) {
		return softwareStufe.fuerServicetechniker(shop, android);
	}
}
