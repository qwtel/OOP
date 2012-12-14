import java.util.ArrayList;
import java.util.List;

/**
 * Eine Bestellung welche an eine Baeckerei übergeben werden kann.
 */
public class Bestellung {
	private List<Position> liste;
	
	/**
	 * Erstellt eine leere Bestellung.
	 */
	public Bestellung() {
		this.liste = new ArrayList<Position>();
	}
	
	/**
	 * Fügt eine Position für ein Einzelkeks zur Bestellliste hinzu.
	 *
	 * @param form Eine gültige Keksform.
	 * @param teigart Eine gültige Teigart.
	 * @param anzahl Die nichtnegative Anzahl der zu backenden Kekse.
	 */
	public void add(Form form, Teigart teigart, int anzahl) {
		liste.add(new Position(form, teigart, anzahl));
	}

	/**
	 * Fügt eine Position für ein Doppelkeks zur Bestellliste hinzu.
	 *
	 * @param form Eine gültige Keksform.
	 * @param teigart Eine gültige Teigart.
	 * @param anzahl Die nichtnegative Anzahl der zu backenden Kekse.
	 * @param fuellung Eine gültige Fuellung wenn ein DoppelKeks erstellt werden
	 *                 soll.
	 */
	public void add(Form form, Teigart teigart, int anzahl, Fuellung fuellung) {
		liste.add(new Position(form, teigart, anzahl, fuellung));
	}
	
	/*
	 * XXX: Client kann die liste verändern! vl doch Interator implementieren?
	 */
	public List<Position> getListe() {
		return liste;
	}

	@Override
	public String toString() {
		String stringListe = "Bestellung:\n";
		int counter = 1;
		for (Position eintrag : liste) {
			stringListe += "----Keksposition "+ (counter++) +"----\n";
			stringListe += eintrag.toString() + "\n";
			
		}
		return stringListe;
	}
	
	public void drucke() {
		System.out.println(toString());
	}
}
