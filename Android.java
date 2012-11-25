
public abstract class Android {
	
	static int seriennummerZaehler = 0;
	private final int seriennummer;

	private Skin skin;
	private Software software;
	
	/**
	 * Erzeugt einen neuen Androiden mit einer eindeutigen Seriennummer.
	 */
	public Android() {
		this.seriennummer = seriennummerZaehler++;
		this.skin = null;
		this.software = null;
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

	public int getSeriennummer() {
		return seriennummer;
	}

	@Override
	public String toString() {
    	return String.format(
			   "Seriennummer: %s\n" +
			   "Skin: %s\n" +
			   "Software: %s\n",
			   seriennummer, skin, software);
	}
}
