import java.util.Scanner;
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
 * @author Florian Klampfer, Michael Ion
 */
public class Description implements Shorter<Description> {

	private String description;

	public Description(String description) {
		this.description = description;
	}

 	/**
	 * Gibt genau dann true zurück, wenn diese Beschreibung kürzer als die 
	 * übergebene Beschreibung ist.
	 *
	 * @param other Die zu vergleichende Description.
	 * @return true, wenn this kürzer als other ist.
	 */
	@Override
	public boolean shorter(Description other) {
		return (this.description.length() < other.description.length());
	}

    /**
	 * Erlaubt das Auslesen der Beschreibung.
	 * @return Die Beschreibung als String.
	 */
	@Override
	public String toString() {
		return description;
	}

	/**
	 * Liefert die Anzahl der Zeilen zurück.
	 * @return Die Anzahl der Zeilen.
	 */
	public int count() {
		int count = 0;
		Scanner sc = new Scanner(description);
		while(sc.hasNextLine()) {
			sc.nextLine();
			++count;
		}
		sc.close();
		return count;
	}
}
