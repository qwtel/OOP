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

	public String drucke() {
		String stringListe = "";
		for (Position eintrag : liste ) {
			stringListe+= eintrag.toString();
		}
		return stringListe;
	}
}