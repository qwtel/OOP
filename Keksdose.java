import java.util.ArrayList;
import java.util.List;


public class Keksdose{
	private List<EinzelKeks> inhalt;
	
	public Keksdose() {
		this.inhalt = new ArrayList<EinzelKeks>(); 
	}
	
	public void add(EinzelKeks keks) {
		inhalt.add(keks);
	}
	
	public String toString() {
		String stringListe = "";
		int counter = 0;
		for(EinzelKeks keks:inhalt) {
			stringListe += "--Keks " + (counter++) + "--\n";
			stringListe += keks.toString();
			stringListe += "\n";
		}
		return stringListe;
	}
	
	public void inhalt() {
		System.out.println(toString());
	}
}
