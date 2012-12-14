import java.util.ArrayList;
import java.util.List;


public class Keksdose{
	private List<Keks> inhalt;
	
	public Keksdose() {
		this.inhalt = new ArrayList<Keks>(); 
	}
	
	public void add(Keks keks) {
		inhalt.add(keks);
	}
	
	public String toString() {
		String stringListe = "";
		for(Keks keks:inhalt) {
			stringListe += keks.toString();
		}
		return stringListe;
	}
	
	public String inhalt() {
		return toString();
	}
}
