
public class Objektbewacher extends Beschuetzer {
	
	public Objektbewacher() {
		super();
	}

	public Objektbewacher(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerObjektbewacher(this);
	}
}
