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
	
	@Override
	public String toString() {
		String stringListe = "";
		int counter = 1;
		for(Keks keks : inhalt) {
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
