import java.util.*;

/**
 * Provides methods to manage multiple bands.
 *
 * @author Florian Klampfer 
 */
public class BandManager {

	/*
	 * GOOD: The AssociationStorage can easily be reused here to provide the
	 * functionality that the user has become used to from managing a single
	 * band.
	 */
	private AssociationStorage<Band> bands;

	public BandManager() {
		bands = new AssociationStorage<Band>();
	}

	/**
	 * @see AssociationStorage
	 */
	public void addBand(Band band) {
		bands.add(band);
	}

	/**
	 * @see AssociationStorage
	 */
	public void removeBand(Band band) {
		bands.remove(band);
	}

	/**
	 * @see AssociationStorage
	 */
	public Set<Band> getBands() {
		return getBands(null);
	}

	/**
	 * @see AssociationStorage
	 */
	public Set<Band> getBands(Date d) {
		return bands.getAt(d);
	}

	/**
	 * Get all active musicians in all bands.
	 *
	 * @param date A past date as Date object or null (precondition).
	 * @return The active musicians to the given date or the currently active
	 * musicians of no date was provided (postcondition).
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
	 *
	 * @param date A past date as Date object or null (precondition).
	 * @return All songs that any of the bands were able to perform at the given
	 *         date or the songs of the currently active bands if no date was
	 *         provided (postcondition).
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
	 *
	 * @param from A past date as Date object (precondition).
	 * @param to A past date that is after the 'from' date. (precondition).
	 * @return All events of all bands in the given time period (postcondition).
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
	 *
	 * @param from A past date as Date object (precondition).
	 * @param to A past date that is after the 'from' date. (precondition).
	 * @return The sum of all incomes minus all expenses over the given time
	 *         period (postcondition).
	 */
	public int getBalance(Date from, Date to) {
		int res = 0;
		for(Band b : getBands(null)) {
			res += b.getBalance(from, to);
		}
		return res;
	}
}
