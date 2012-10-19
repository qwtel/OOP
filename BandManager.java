import java.util.*;

/**
 * Provides methods to manage multiple bands.
 *
 * @author Florian Klampfer 
 */
public class BandManager {
	private AssociationStorage<Band> bands;

	public BandManager() {
		bands = new AssociationStorage<Band>();
	}

	public void addBand(Band band) {
		bands.add(band);
	}

	public void removeBand(Band band) {
		bands.remove(band);
	}

	/**
	 * TODO
	 */
	public Collection<Musician> getMusicians() {
		return new HashSet<Musician>();
	}

	/**
	 * TODO
	 */
	public Collection<Song> getSongs() {
		return new HashSet<Song>();
	}

	/**
	 * TODO
	 */
	public Collection<Event> getEvents() {
		return new ArrayList<Event>();
	}

	/**
	 * TODO
	 */
	public int getBalance() {
		return 0;
	}
}
