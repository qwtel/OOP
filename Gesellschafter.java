
public class Gesellschafter extends Bediener {
	
	@Override
	public void installSoftware(Software software) {
		software.fuerGesellschafter(this);
	}
}
