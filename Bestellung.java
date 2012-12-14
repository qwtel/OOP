import java.util.ArrayList;
import java.util.List;

public class Bestellung {
	private List<Position> liste;
	
	public Bestellung() {
		this.liste = new ArrayList<Position>();
	}
	
	public void add(Form form, int anzahl, Teigart teigart) {
		liste.add(new Position(form, anzahl, teigart));
	}
	
	public List<Position> getListe() {
		return liste;
	}

	public String toString() {
		String stringListe = "Bestellung:\n";
		int counter = 0;
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