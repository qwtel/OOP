import java.util.ArrayList;

/**
 * Führt eine Liste mit allen Androiden
 *
 */
public class AndroidList {
	private ArrayList<Seriennummer> al;
	
	public AndroidList() {
		al = new ArrayList<Seriennummer>();
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
	public void insert(Seriennummer a) {
		
	}
}
