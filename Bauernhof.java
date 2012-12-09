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
}
