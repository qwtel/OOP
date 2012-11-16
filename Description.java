/**
 * Description
 *
 * Description ist ein Untertyp von Shorter, der einen beschreibenden Text 
 * darstellt. 
 *
 * Der Text wird im Konstruktor gesetzt und durch toString ausgelesen. 
 * Ein Vergleich mit shorter vergleicht die Texte anhand ihrer Längen in 
 * Zeichen. Es gibt eine Methode um die Anzahl der Zeilen zu ermitteln.
 *
 * @author TODO, Florian Klampfer
 */
public class Description implements Shorter<Description> {

	private String description;

	public Description(String description) {
		this.description = description;
	}

	@Override
	public boolean shorter(Description other) {
		return (this.count() < other.count());
	}

	@Override
	public String toString() {
		return description;
	}

	/**
	 * Liefert die Anzahl der Zeichen zurück.
	 * @return Die Anzahl der Zeichen.
	 */
	public int count() {
		return description.length();
	}
}
