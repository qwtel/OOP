
public class SoftwareStufe4 extends SoftwareStufe{

	@Override
	boolean fuerBauarbeiter(RoboShop shop, Bauarbeiter android) {
		return android.aktor.fuerStufe4(shop, android);
	}

	@Override
	boolean fuerServicetechniker(RoboShop shop, Servicetechniker android) {
		return android.aktor.fuerStufe4(shop, android);
	}

	@Override
	boolean fuerTransportarbeiter(RoboShop shop, Transportarbeiter android) {
		return android.aktor.fuerStufe4(shop, android);
	}

	@Override
	boolean fuerObjektbewacher(RoboShop shop, Objektbewacher android) {
		return android.aktor.fuerStufe4(shop, android);
	}

	@Override
	boolean fuerLeibwaechter(RoboShop shop, Leibwaechter android) {
		return android.aktor.fuerStufe4(shop, android);
	}
}
