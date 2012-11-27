
public abstract class Android {
	
	/**
	 * Entspricht immer der Anzahl ausgelieferter Androiden.
	 */
	private static int seriennummerZaehler = 0;

	static int getSeriennummerZaehler() {
    	return seriennummerZaehler;
	}

	/**
	 * Die Seriennummer des Androiden.
	 */
	private final int seriennummer;

	private Skin skin;
	private Software software;
	private Aktor aktor;
	
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

	/**
	 * Stattet den Androiden mit einer Skin aus. 
	 *
	 * Die Seriennummer der Skin muss mit der des Androiden übereinstimmen 
	 * (Vorbedingung). 
	 *
	 * Ist die spezifizierte Skin für den Typ dieses Androiden nicht zulässig,
	 * wird skin auf null gesetzt (Nachbedingung).
	 *
	 * @param skin Die Skin für diesen Androiden. Die Seriennummer muss mit der
	 *         des Androiden übereinstimmen.
	 */
	public abstract void installSkin(Skin skin);

	/**
	 * Setter-Methode für die Skin. Default-Sichtbarkeit, wird nur von
	 * Untertypen von Skin verwendet um skin dieses Androiden setzen zu können.
	 *
	 * @param skin Die Skin für diesen Androiden. Die Seriennummer muss
	 *         mit der des Androiden übereinstimmen. Der Typ der Skin muss
	 *         mit dem Typ des Androiden kompatibel sein.
	 */
	void setSkin(Skin skin) {
    	this.skin = skin;
	}

	public Skin getSkin() {
		return skin;
	}

	/**
	 * Stattet den Androiden mit einer Software aus. 
	 *
	 * Die Seriennummer der Software muss mit der des Androiden übereinstimmen
	 * (Vorbedingung). 
	 *
	 * Ist die spezifizierte Software für den Typ dieses Androiden nicht 
	 * zulässig, wird software auf null gesetzt (Nachbedingung).
	 *
	 * @param software Die Software für diesen Androiden. Die Seriennummer muss
	 *         mit der des Androiden übereinstimmen.
	 */
	public abstract void installSoftware(Software software);


	/**
	 * Setter-Methode für die Software. Default-Sichtbarkeit, wird nur von
	 * Untertypen von Software verwendet um software dieses Androiden setzen zu
	 * können.
	 *
	 * @param software Die Software für diesen Androiden. Die Seriennummer muss
	 *         mit der des Androiden übereinstimmen. Der Typ der Software muss
	 *         mit dem Typ des Androiden kompatibel sein.
	 */
	void setSoftware(Software software) {
    	this.software = software;
	}

	public Software getSoftware() {
		return software;
	}
	
	/**
	 * Stattet den Androiden mit einem Aktor aus. 
	 *
	 * Die Seriennummer des Aktors muss mit der des Androiden übereinstimmen
	 * (Vorbedingung). 
	 * 
	 * Der Aktor muss mit der Softwarestufe des Androiden kompatibel sein. (Vorbedingung)
	 *
	 * Ist der spezifizierte Aktorfür den Typ dieses Androiden nicht 
	 * zulässig, wird aktor auf null gesetzt (Nachbedingung).
	 *
	 * @param aktor Der Aktor für diesen Androiden. Die Seriennummer muss
	 *         mit der des Androiden übereinstimmen.
	 */	
	public abstract void installAktor(Aktor aktor);

	/**
	 * Setter-Methode für den Aktor. Default-Sichtbarkeit, wird nur von
	 * Untertypen von Aktor verwendet um aktor dieses Androiden setzen zu
	 * können.
	 *
	 * @param aktor Der Aktor für diesen Androiden. Die Seriennummer muss
	 *         mit der des Androiden übereinstimmen. Der Typ des Aktors muss
	 *         mit dem Typ der Software des Androiden kompatibel sein.
	 */
	void setAktor(Aktor aktor) {
    	this.aktor= aktor;
	}
	
	public Aktor getAktor() {
		return aktor;
	}	
	
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
