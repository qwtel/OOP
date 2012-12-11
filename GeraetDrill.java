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

	public GeraetDrill(int zahl) {
		this.zahl = zahl;
	}

	@Override
	@MethodAuthor(who="Michael Ion")
	public Number getAnzahl() {
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
