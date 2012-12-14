/**
 * Stellt ein Element einer Bestellung dar. Enthält die gewünschte Anzahl an Keksen aus spezifizierten
 * Bestandteilen
 */
public class Position {
	private Form form;
	private int anzahl;
	private Teigart teigart;
	private Fuellung fuellung;
	
	public Position(Form form, int anzahl, Teigart teigart) {
		this.form = form;
		this.anzahl = anzahl;
		this.teigart = teigart;
	}

	public Position(Form form, int anzahl, Teigart teigart, Fuellung fuellung) {
		this(form, anzahl, teigart);
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
}
