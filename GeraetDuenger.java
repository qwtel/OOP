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
	Tupel getBetriebszeitDuengen(Traktor t) {
		int x = t.getBetriebszeit();
		return new Tupel(x, 1);
	}
	
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchDuengen(Traktor t) {
		int x = t.getTreibstoffverbrauch().intValue();
		return new Tupel(x, 1);
	}
	
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchDuengen(Traktor t) {
		float x = t.getTreibstoffverbrauch().floatValue();
		return new Tupel(x, 1);
	}
	
	@Override	
	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaet() {
		return kapazitaet;
	}
}
