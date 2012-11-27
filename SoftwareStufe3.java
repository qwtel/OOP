
public class SoftwareStufe3 extends SoftwareStufe{

	@Override
	boolean fuerBauarbeiter(RoboShop shop, Bauarbeiter android) {
		return android.aktor.fuerStufe3(shop, android);
	}

	@Override
	boolean fuerServicetechniker(RoboShop shop, Servicetechniker android) {
		return android.aktor.fuerStufe3(shop, android);
	}

	@Override
	boolean fuerTransportarbeiter(RoboShop shop, Transportarbeiter android) {
		return android.aktor.fuerStufe3(shop, android);
	}
}
