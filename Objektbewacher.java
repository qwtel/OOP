
public class Objektbewacher extends Beschuetzer {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerObjektbewacher(this);
	}
}
