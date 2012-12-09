/**
 *
 */
@ClassAuthor(who="Florian Klampfer")
public class Bauernhof {

	private final String name;
	private Set<Traktor> traktoren;

	/**
	 * TODO: Zusicherungen
	 */
	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Set<Traktor>();
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public boolean addTraktor(Traktor t) {
		return traktoren.insert(t);
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public boolean removeTraktor(Traktor t) {
		return traktoren.insert(t);
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeit() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			sum += t.getBetriebszeit();
			count++;
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitDuengen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t.geraet instanceof GeraetDuenger) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitSaeen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t.geraet instanceof GeraetDrill) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}
}
