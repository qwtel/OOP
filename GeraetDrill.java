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
	public Number getZahl() {
		return zahl;
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitSaeen(Traktor t) {
		int x = t.getBetriebszeit();
		return new Tupel(x, 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchSaeen(Traktor t) {
		int x = t.getTreibstoffverbrauch().intValue();
		return new Tupel(x, 1);
	}
	
	@Override
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchSaeen(Traktor t) {
		float x = t.getTreibstoffverbrauch().floatValue();
		return new Tupel(x, 1);
	}

	@Override
	@MethodAuthor(who="Florian Klampfer")
	int getSaescharen() {
		return zahl;
	}
}
