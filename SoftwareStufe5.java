
public class SoftwareStufe5 extends SoftwareStufe{

	@Override
	boolean fuerKaempfer(RoboShop shop, Kaempfer android) {
		return android.aktor.fuerKaempfer(shop, android);
	}
}
