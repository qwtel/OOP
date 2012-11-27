
public class SoftwareGesellschafter extends Software {
	
	public SoftwareGesellschafter(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}

	@Override
	boolean fuerGesellschafter(RoboShop shop, Gesellschafter android) {
		return softwareStufe.fuerGesellschafter(shop, android);
	}
}
