
public abstract class Android {
	
	/**
	 * Entspricht immer der Anzahl ausgelieferter Androiden.
	 */
	private static int seriennummerZaehler = 0;

	/**
	 * Liefert die höchste vergeben Seriennummer.
	 *
	 * @return Die Seriennummer des zuletzt ausgelieferten Androiden.
	 */
	static int getSeriennummerZaehler() {
		return seriennummerZaehler;
	}

	/**
	 * Die Seriennummer des Androiden.
	 */
	private final int seriennummer;

	Skin skin;
	Software software;
	SensorAktorKit aktor;

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public void setAktor(SensorAktorKit aktor) {
		this.aktor = aktor;
	}

	/**
	 * Erzeugt einen neuen Androiden mit einer eindeutigen Seriennummer.
	 */
	public Android() {
		this.seriennummer = seriennummerZaehler++;
		this.skin = null;
		this.software = null;
		this.aktor = null;
	}

	/**
	 * Erzeugt einen Androiden mit der angegebenen Seriennummer.
	 * Darf nur zum Upgraden bereits ausgelieferter Androiden verwendet werden.
	 *
	 * @param seriennummer Muss kleiner gleich seriennummerZaehler sein.
	 */
	public Android(int seriennummer) {
		this.seriennummer = seriennummer;
		this.skin = null;
		this.software = null;
		this.aktor = null;
	}

	boolean insert(RoboShop shop) {
		return false;
	}

	boolean insert2(RoboShop shop) {
		return false;
	}

	/**
	 * Liefert die Seriennummer des Androiden.
	 *
	 * @return Die Seriennummer des Androiden.
	 */
	public int getSeriennummer() {
		return seriennummer;
	}

	@Override
	public String toString() {
		return String.format(
			   "Seriennummer: %s\n" +
			   "Skin: %s\n" +
			   "Software: %s\n" +
			   "Sensoren/Aktoren: %s\n",
			   seriennummer, skin, software, aktor);
	}
}
