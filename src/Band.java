import java.util.*;

/**
 * Provides methods to manage a band.
 * @author Florian Klampfer, Johannes Deml, Michael Ion
 */
class Band {
	private List<Event> events;
	private List<Musician> musicians;
	private List<Song> songs;

	private HashMap<Object, LogEntry> log;

	public Band() {
		events = new ArrayList<Event>();
		musicians = new ArrayList<Musician>();
		songs = new ArrayList<Song>();

		log = new HashMap<Object, LogEntry>();
	}

	public void addMusician(Musician musician) {
		add(musicians, musician);
	}

	public void removeMusician(Musician musician) {
		remove(musicians, musician);
	}

	public List<Musician> getMusicians() {
		return new ArrayList<Musician>(filter(musicians, null));
	}

	public List<Musician> getMusicians(Date d) {
		return new ArrayList<Musician>(filter(musicians, d));
	}

	public void addSong(Song song) {
		add(songs, song);
	}

	public void removeSong(Song song) {
		remove(songs, song);
	}

	public List<Song> getSongs() {
		return new ArrayList<Song>(filter(songs, null));
	}

	public List<Song> getSongs(Date d) {
		return new ArrayList<Song>(filter(songs, d));
	}

	/**
	 * Returns the active items of a list based on a given date and the log.
	 * If no date is provided (= null) the currently active elements will be
	 * returned.
	 *
	 * @param list The list to be filtered.
	 * @param d A past date as Date object or null
	 * @return The active list items to a given date or the currently active
	 *         items if no date was provided.
	 */
	private List filter(List list, Date d) {
		List res = new ArrayList();
		for (Object o : list) {
			LogEntry e = log.get(o);
			if (e.isActive(d)) {
				res.add(o);
			}
		}
		return res;
	}

	/**
	 * Adds an item to a list and creates an entry in the log.
	 */
	private void add(List list, Object o) {
		list.add(o);
		LogEntry logEntry = new LogEntry();
		log.put(o, logEntry);
	}

	/**
	 * Removes an item from a list by updating the entry in the log.
	 */
	private void remove(List list, Object o) {
		LogEntry logEntry = log.get(o);
		logEntry.end();
	}
}
