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
	
	public String toString() {
		String auflistung = "";
		auflistung += "Form: " +form.toString() +", \n";
		auflistung += "Anzahl: " +anzahl +", \n";
		auflistung += "Teigart: " +teigart.toString() +", \n";
		auflistung += "Fuellung: " +fuellung.toString() +", \n";
		return auflistung;
	}
}
