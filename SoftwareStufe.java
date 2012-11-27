
public abstract class SoftwareStufe {

	boolean fuerHilfskraft(RoboShop shop, Hilfskraft android) {
		return false;
	}

	boolean fuerGesellschafter(RoboShop shop, Gesellschafter android) {
		return false;
	}

	boolean fuerBauarbeiter(RoboShop shop, Bauarbeiter android) {
		return false;
	}

	boolean fuerServicetechniker(RoboShop shop, Servicetechniker android) {
		return false;
	}

	boolean fuerTransportarbeiter(RoboShop shop, Transportarbeiter android) {
		return false;
	}

	boolean fuerObjektbewacher(RoboShop shop, Objektbewacher android) {
		return false;
	}

	boolean fuerLeibwaechter(RoboShop shop, Leibwaechter android) {
		return false;
	}

	boolean fuerKaempfer(RoboShop shop, Kaempfer android) {
		return false;
	}
}
