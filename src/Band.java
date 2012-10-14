import java.util.*;

/**
 * Provides methods to manage a band.
 * @author Florian Klampfer, Johannes Deml, Michael Ion
 */
class Band {
	private List<Event> events;
	private List<Musician> musicians;
	private List<Song> songs;

	private HashMap<Object, LogEntry> bandHistory;

	public Band() {
		events = new ArrayList<Event>();
		musicians = new ArrayList<Musician>();
		songs = new ArrayList<Song>();

		bandHistory = new HashMap<Object, LogEntry>();
	}

	public void addMusician(Musician musician) {
		add(musicians, musician);
	}

	public void removeMusician(Musician musician) {
		remove(musicians, musician);
	}

	public List<Musician> getMusicians() {
		return new ArrayList<Musician>();
	}

	public List<Musician> getMusicians(Date d) {
		return new ArrayList<Musician>();
	}

	public void addSong(Song song) {
		add(songs, song);
	}

	public void removeSong(Song song) {
		remove(songs, song);
	}

	public List<Song> getSongs() {
		return new ArrayList<Song>();
	}

	public List<Song> getSongs(Date d) {
		return new ArrayList<Song>();
	}

	/**
	 * Adds an item to a list and creates an entry in the log.
	 * Helper function to reduce duplicate code.
	 */
	private void add(List list, Object o) {
		list.add(o);
		LogEntry logEntry = new LogEntry();
		bandHistory.put(o, logEntry);
	}

	/**
	 * Removes an item from a list and updates the log.
	 * Helper function to reduce duplicate code.
	 */
	private void remove(List list, Object o) {
		if (list.contains(o)) {
			LogEntry logEntry = bandHistory.get(o);
			logEntry.end();
			list.remove(o);
		}
	}
}
