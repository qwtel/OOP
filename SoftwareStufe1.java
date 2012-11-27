
public class SoftwareStufe1 extends SoftwareStufe {

	@Override
	boolean fuerHilfskraft(RoboShop shop, Hilfskraft android) { 
		return android.aktor.fuerBediener(shop, android);
	}

	@Override
	boolean fuerGesellschafter(RoboShop shop, Gesellschafter android) { 
		return android.aktor.fuerBediener(shop, android);
	}
}
