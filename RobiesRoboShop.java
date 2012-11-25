import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Führt eine Liste mit allen Androiden
 */
public class RobiesRoboShop implements Iterable<Android> {

	/**
	 * Die "Liste" ausgelieferter Androiden.
	 * Der Key entspricht der Seriennummer des Androiden.
	 */
	private HashMap<Integer, Android> androidenListe; 
	private ArrayList<Integer> einfuegeReihenfolge;
	
	public RobiesRoboShop() {
 		androidenListe = new HashMap<Integer, Android>(); 
		einfuegeReihenfolge = new ArrayList<Integer>();
	}

	/**
	 * Fügt einen Androiden mit eindeutiger Seriennummer und allen 
	 * Ausstattungsdetails in die Liste ein und prüft die Bedingungen der 
	 * Androide-Verordnung. 
	 *
	 * Sind die Bedingungen nicht erfüllt, bleibt die Liste unverändert, und 
	 * ein entsprechender Fehlercode wird zurückgegeben. 
	 *
	 * Kommt ein Androide mit derselben Seriennummer bereits in der Liste vor, 
	 * so handelt es sich um eine Änderung, sonst um die Auslieferung eines 
	 * neuen Androiden. 
	 *
	 * @param android Ein Androide mit einer eindeutigen Seriennummer. Kommt der
	 *          Androide mit der Seriennummer bereits in der Liste vor, handelt 
	 *          es sich um eine Änderung und es darf der Haupttyp (Bediener, 
	 *          Schwerarbeiter oder Beschützer) nicht geändert werden.
	 * @param skin Die Skin mit welcher der Androide ausgeliefert werden soll.
	 *          Die Seriennummer der Skin muss der Seriennummer des Androiden
	 *          entsprechen.
	 * @param software Die Software mit welcher der Androide ausgeliefert werden
	 *          soll. Die Seriennummer der Software muss der Seriennummer des 
	 *          Androiden entsprechen. Handelt es sich um eine Änderung darf die
	 *          Sicherheitsstufe nicht geändert werden.
	 * @return false wenn der Androide nicht der Androide-Verordnung entspricht.
	 */
	public boolean insert(Android android, Skin skin, Software software) {

		android.installSkin(skin);
		android.installSoftware(software);

		if(android.getSkin() != null && android.getSoftware() != null) {
			int seriennummer = android.getSeriennummer();
			if(androidenListe.get(seriennummer) == null) {
            	einfuegeReihenfolge.add(seriennummer);
			}
			androidenListe.put(seriennummer, android);
			return true;
		}
		return false;
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
		Android a = androidenListe.get(seriennummer);
		if(a != null) {
			return a.toString();
		}
		return null;
	}

	/**
	 * Erzeugt einen Iterator über den ausgelieferten Androiden in der 
	 * Reihenfolge der ersten Auslieferung (das ist die Reihenfolge des 
	 * Einfügens neuer Androiden).
	 *
	 * @return Ein Iterator über alle ausgelieferten Androiden.
	 */
   	@Override
   	public Iterator<Android> iterator() {
 		return new RoboShopIterator();
   	}

	private class RoboShopIterator implements Iterator<Android> {

		private Iterator<Integer> i = einfuegeReihenfolge.iterator();

		@Override
		public boolean hasNext() {
			return i.hasNext();
		}

		@Override
		public Android next() {
			return androidenListe.get(i.next());
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}
}
