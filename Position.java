/**
 * Stellt ein Element einer Bestellung dar und kapselt die Paramter zur 
 * Kekserstellung.
 */
class Position {
	private Form form;
	private Teigart teigart;
	private int anzahl;
	private Fuellung fuellung;
	
	/**
	 * @param form Eine gültige Keksform.
	 * @param teigart Eine gültige Teigart.
	 * @param anzahl Die nichtnegative Anzahl der zu backenden Kekse.
	 */
	public Position(Form form, Teigart teigart, int anzahl) {
		this.form = form;
		this.anzahl = anzahl;
		this.teigart = teigart;
		this.fuellung = null;
	}

	/**
	 * @param form Eine gültige Keksform.
	 * @param teigart Eine gültige Teigart.
	 * @param anzahl Die nichtnegative Anzahl der zu backenden Kekse.
	 * @param fuellung Eine gültige Fuellung wenn ein DoppelKeks erstellt werden
	 *                 soll.
	 */
	public Position(Form form, Teigart teigart, int anzahl, Fuellung fuellung) {
		this(form, teigart, anzahl);
		this.fuellung = fuellung;
	}

	public Form getForm() {
		return form;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public Teigart getTeigart() {
		return teigart;
	}
	
	public Fuellung getFuellung() {
		return fuellung;
	}
	
	public String toString() {
		// TODO: Füllung
		String auflistung = "";
		auflistung += "Form: " +form.toString();
		auflistung += ", \nAnzahl: " +anzahl;
		auflistung += ", \nTeigart: " +teigart.toString();
		//auflistung += ", \nFuellung: " +fuellung.toString();
		auflistung += "\n";
		return auflistung;
	}
}
