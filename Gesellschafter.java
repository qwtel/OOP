
public class Gesellschafter extends Bediener {
	
	public Gesellschafter() {
		super();
	}

	public Gesellschafter(int seriennummer) {
		super(seriennummer);
	}

	@Override
	public void installSoftware(Software software) {
		software.fuerGesellschafter(this);
	}
}
