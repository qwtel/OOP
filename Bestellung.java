import java.util.ArrayList;
import java.util.List;

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
		String stringListe = "Bestellung:\n";
		for (int i=0; i<liste.size(); i++ ) {
			stringListe += "Keksart"+(i);
			stringListe += liste.get(i).toString();
		}
		return stringListe;
	}
}