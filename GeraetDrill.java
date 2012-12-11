/**
 * GeraetDrill hat immer eine Infomation ueber die Anzahl der vorhandenen 
 * Saescharen. Dies muss immer eine ganze Zahl sein.
 * 
 * @author Michael Ion
 *
 */
@ClassAuthor(who="Michael Ion")
public class GeraetDrill extends Geraet {
	private int zahl;

	/**
	 * Erstellt einen neuen GeraetDrill mit der spezifizierten zahl (ist eine Ganzzahl)
	 */
	public GeraetDrill(int zahl) {
		this.zahl = zahl;
	}

	@Override
	@MethodAuthor(who="Michael Ion")
	/**
	 * Gibt die Anzahl der vorhandenen Saescharen zurück (muss eine Ganzzahl sein)
	 */
	public Integer getAnzahl() {
		return zahl;
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorSaeen(Traktor t) {
		return t;
	}
}
