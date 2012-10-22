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

	public Set<Band> getBands() {
		return getBands(null);
	}

	public Set<Band> getBands(Date d) {
		return bands.getAt(d);
	}

	/**
	 * Get all musicians in all bands.
	 */
	public Set<Musician> getMusicians(Date d) {
		Set<Musician> res = new HashSet<Musician>();
		for(Band b : getBands(d)) {
			res.addAll(b.getMusicians(d));
		}
		return res;
	}

	public Set<Musician> getMusicians() {
		return getMusicians(null);
	}

	/**
	 * Get a complete collection of all songs.
	 */
	public Set<Song> getSongs(Date d) {
		Set<Song> res = new HashSet<Song>();
		for(Band b : getBands(d)) {
			res.addAll(b.getSongs(d));
		}
		return res;
	}

	public Set<Song> getSongs() {
		return getSongs(null);
	}

	/**
	 * Get the events of all bands.
	 */
	public Set<Event> getEvents(Date from, Date to) {
		Set<Event> res = new HashSet<Event>();
		for(Band b : getBands(null)) {
			res.addAll(b.getEvents(from, to));
		}
		return res;
	}

	/**
	 * Get the balance over all bands from-to.
	 */
	public int getBalance(Date from, Date to) {
		int res = 0;
		for(Band b : getBands(null)) {
			res += b.getBalance(from, to);
		}
		return res;
	}
}
