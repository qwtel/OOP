
public abstract class Android {
	
	private static int serialNumberCounter = 0;
	private final int serialNumber;
	
	public Android() {
		this.serialNumber = serialNumberCounter++;
	}
	
}
