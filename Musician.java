import java.util.*;

/**
 * Provides basic methods to manage a musician.
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

	public Set<Song> getSongs() {
		return songs.getAt(null);
	}

	public Set<Song> getSongs(Date date) {
		return songs.getAt(date);
	}

	@Override
	public String toString() {
		return "Name: "+name+" Tel: "+tel+" Ins: "+instrument;

	}
}
