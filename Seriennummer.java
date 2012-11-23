
public class Seriennummer {
	private static int seriennummerZaehler =0;
	private final int seriennummer;
	private Android android;
	
	public Seriennummer() {
		this.seriennummer = seriennummerZaehler++;
	}
	
}
