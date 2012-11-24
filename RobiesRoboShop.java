import java.util.ArrayList;
import java.util.Iterator;

/**
 * Führt eine Liste mit allen Androiden
 *
 */
public class RobiesRoboShop {
	private ArrayList<Android> al;
	
	public RobiesRoboShop() {
		al = new ArrayList<Android>();
	}
	/**
	 * Fügt einen Androiden mit eindeutiger Seriennummer und allen Ausstattungsdetails
	 * in die Liste ein und prüft die Bedingungen der Androide-Verordnung. Sind die 
	 * Bedingungen nicht erfüllt, bleibt die Liste unverändert, und ein entsprechender
	 *  Fehlercode wird zurückgegeben. Kommt ein Androide mit derselben Seriennummer
	 *   bereits in der Liste vor, so handelt es sich um eine Änderung, sonst um die 
	 *   Auslieferung eines neuen Androiden. Als Ausstattungsdetails bekommt jeder
	 * Android ein Sensoren-Aktoren-Kit, eine Skin und eine Software mit.
	 * @param a
	 */
	public void insert(Android a) {
		if(a.getSkin() != null && a.getSoftware() != null) {
			if(! al.contains(a)) {
				al.add(a);
			} else {
				 //schauen ob es den gleichen Haupttyp und Seriennummmer hat
				
			}
		}
	}
	
	public String find(String seriennummer) {
		return "";
	}
	
	public Iterator<Android> iterator() {
		return al.iterator();
	}
}
