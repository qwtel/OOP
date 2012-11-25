import java.util.HashSet;
import java.util.Iterator;

/**
 * Führt eine Liste mit allen Androiden
 */
public class RobiesRoboShop implements Iterable<Android> {
	private Android[] androidenListe;
	private ArrayList<Android> einfuegeReihenfolge;
	
	public RobiesRoboShop() {
		androidenListe = new Android[1];
		einfuegeReihenfolge = new ArrayList<Android>();
	}

	/**
	 * Fügt einen Androiden mit eindeutiger Seriennummer in die Liste ein und 
	 * prüft die Bedingungen der Androide-Verordnung. 
	 *
	 * Sind die Bedingungen nicht erfüllt, bleibt die Liste unverändert, und 
	 * ein entsprechender Fehlercode wird zurückgegeben. 
	 *
	 * Kommt ein Androide mit derselben Seriennummer bereits in der Liste vor, 
	 * so handelt es sich um eine Änderung, sonst um die Auslieferung eines 
	 * neuen Androiden. 
	 *
	 * @param android Ein Androide mit einer eindeutigen Seriennummer. Handelt 
	 *          es sich um eine Änderung darf der Haupttyp (Bediener, 
	 *          Schwerarbeiter oder Beschützer) sowie die Sicherheitsstufe der 
	 *          Software nicht geändert werden.
	 * @return false wenn der Androide nicht der Androide-Verordnung entspricht.
	 */
	public boolean insert(Android android) {

		ensureCapacity(Android.seriennummerZaehler);

		if(android.getSkin() != null && android.getSoftware() != null) {
			int seriennummer = android.getSeriennummer();

			if(androidenListe[seriennummer] == null) {
				einfuegeReihenfolge.add(android);
			}

			androidenListe[seriennummer] = android;
		}
		return false;
	}

	private void ensureCapacity(int n) {
 		Android[] neueAndroidenListe = new Android[n];
		System.arraycopy(androidenListe, 0, neueAndroidenListe, 0,
				androidenListe.length);
		androidenListe = neueAndroidenListe;
	}
	
	/**
	 * Liefert einen String mit der Beschreibung aller Ausstattungsdetails des 
	 * Androiden mit der als Parameter gegebenen Seriennummer zurück (oder null 
	 * falls kein Androide mit dieser Seriennummer existiert).
	 *
	 * @param seriennummer Seriennummer des gesuchten Androiden.
	 * @return Ein String mit der Beschreibung aller Ausstattungsdetails des 
	 *         Androiden oder null.
	 */
	public String find(int seriennummer) {
		return androidenListe[seriennummer].toString();
	}

	@Override
	public Iterator<Android> iterator() {
		return einfuegeReihenfolge.iterator();
	}
	
	public Iterator<Android> iterator() {
		return al.iterator();
	}
}
