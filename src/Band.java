import java.util.*;

/**
 * Provides methods to manage a band.
 * @author Johannes Deml, Michael Ion, Florian Klampfer 
 */
class Band {
	private List<Event> events;
	private LoggedArrayList<Musician> musicians;
	private LoggedArrayList<Song> songs;

	public Band() {
		events = new ArrayList<Event>();
		musicians = new LoggedArrayList<Musician>();
		songs = new LoggedArrayList<Song>();
	}

	public void addMusician(Musician musician) {
		musicians.add(musician);
	}

	public void removeMusician(Musician musician) {
		musicians.markInactive(musician);
	}

	public List<Musician> getMusicians() {
		return musicians.getAll(null);
	}

	public List<Musician> getMusicians(Date at) {
		return musicians.getAll(at);
	}

	public void addSong(Song song) {
		songs.add(song);
	}

	public void removeSong(Song song) {
		songs.markInactive(song);
	}

	public List<Song> getSongs() {
		return songs.getAll(null);
	}

	public List<Song> getSongs(Date at) {
		return songs.getAll(at);
	}
}
