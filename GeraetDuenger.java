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
	 * Erstellt einen neuen GeraetDuenger mit der spezifizierten Kapazitaet
	 */
	public GeraetDuenger(float kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	@Override
	@MethodAuthor(who="Michael Ion")
	public Number getZahl() {
		return kapazitaet;
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorDuengen(Traktor t) {
		return t;
	}
}
