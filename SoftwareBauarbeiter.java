
public class SoftwareBauarbeiter extends Software {

	public SoftwareBauarbeiter(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}

	@Override
	boolean fuerBauarbeiter(RoboShop shop, Bauarbeiter android) {
		return softwareStufe.fuerBauarbeiter(shop, android);
	}
}
