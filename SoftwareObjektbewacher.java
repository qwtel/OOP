
public class SoftwareObjektbewacher extends Software {

	public SoftwareObjektbewacher(int s, SoftwareStufe softwareStufe) {
		super(s, softwareStufe);
	}	
		
	@Override
	boolean fuerObjektbewacher(RoboShop shop, Objektbewacher android) {
		return softwareStufe.fuerObjektbewacher(shop, android);
	}
}
