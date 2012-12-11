/**
 * GeraetDuenger hat immer eine Infomation ueber die Kapazitaet des
 * Behaelters. Dies muss eine Gleitkommazahl sein.
 * 
 * @author Michael Ion
 *
 */
@ClassAuthor(who="Michael Ion")
public class GeraetDuenger extends Geraet {
	private float kapazitaet;

	/**
	 * Erstellt einen neuen GeraetDuenger mit der spezifizierten Kapazitaet (ist eine Gleitkommazahl)
	 */
	public GeraetDuenger(float kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	/**
	 * Gibt die Kapazitaet des Behaelters zurück (muss eine Gleitkommazahl sein)
	 */
	@Override
	@MethodAuthor(who="Michael Ion")
	public Float getAnzahl() {
		return kapazitaet;
	}

	/**
	 * Liefert den Traktor wenn er die Bedingung erfüllt, ansonsten null.
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDuengen(Traktor t) {
		return t;
	}
}
