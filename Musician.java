import java.util.*;

/**
 * Represents a musician.
 * @author Florian Klampfer
 */
public class Musician {
	private final String name;
	private final String tel;
	private final String instrument;

	private LoggedArrayList<Song> songs;

	public Musician(String name, String tel, String instrument) {
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
		this.songs = new LoggedArrayList<Song>();
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getInstrument() {
		return instrument;
	}

	public void addSong(Song song) {
		songs.add(song);
	}

	public void removeSong(Song song) {
		songs.remove(song);
	}

	public List<Song> getSongs() {
		return songs.getAll(null);
	}

	public List<Song> getSongs(Date at) {
		return songs.getAll(at);
	}

	@Override
	public String toString() {
		return "Name: "+name+" Tel: "+tel+" Ins: "+instrument;

	}
}
