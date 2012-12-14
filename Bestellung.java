import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Position;


public class Bestellung {
	private List<Position> liste;
	
	public Bestellung() {
		this.liste = new ArrayList<Position>();
	}
	
	public void add(Position eintrag) {
		liste.add(eintrag);
	}
	
	public List<Position> getListe() {
		return liste;
	}

	public String toString() {
		String stringListe = "Bestellung:\n";
		for (int i=0; i<liste.size(); i++ ) {
			stringListe += "Keksbestellung"+(i) +":\n";
			stringListe += liste.get(i).toString();
		}
		return stringListe;
	}
	
	public String drucke() {
		return toString();
	}
}