
public abstract class Android {
	
	private static int seriennummerZaehler =0;
	private final int seriennummer;
	private Skin skin;
	private Software software;
	
	public Android() {
		this.seriennummer = seriennummerZaehler++;
	}
	
	public Android(int seriennummer) {
		this.seriennummer = seriennummer;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public int getSeriennummer() {
		return seriennummer;
	}
	public String toString() {
		return software.toString() + skin.toString();
	}
}
