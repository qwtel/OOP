
public class SoftwareStufe2 extends SoftwareStufe{

	@Override
	boolean fuerHilfskraft(RoboShop shop, Hilfskraft android) { 
		return android.aktor.fuerBediener(shop, android);
	}
}
