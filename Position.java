/**
 *
 */
public class Position {
	Form form;
	int anzahl;
	Teigart teigart;
	Fuellung fuellung;
	
	public Position(Form form, int anzahl, Teigart teigart) {
		this.form = form;
		this.anzahl = anzahl;
		this.teigart = teigart;
	}

	public Position(Form form, int anzahl, Teigart teigart, Fuellung fuellung) {
		this(form, anzahl, teigart);
		this.fuellung = fuellung;
	}
}
