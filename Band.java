import java.util.*;

/**
 * Provides methods to manage a band.
 * @author Johannes Deml, Michael Ion, Florian Klampfer 
 */
public class Band {
	private List<Event> events;
	private LoggedArrayList<Musician> musicians;
	private LoggedArrayList<Musician> secondaryMusicians;

	public Band() {
		events = new ArrayList<Event>();
		musicians = new LoggedArrayList<Musician>();
		secondaryMusicians = new LoggedArrayList<Musician>();
	}
	
	public void addEvent(Event e){
		events.add(e);
	}
	
	public void removeEvent(Event e){
		events.remove(e);
	}

	public void addMusician(Musician musician) {
		musicians.add(musician);
	}

	public void removeMusician(Musician musician) {
		musicians.remove(musician);
	}

	public Set<Musician> getMusicians() {
		return musicians.getAt(null);
	}

	public Set<Musician> getMusicians(Date date) {
		return musicians.getAt(date);
	}

	/**
	 * Adds a song to all currently active musiceans.
	 */
	public void addSong(Song song) {
		for(Musician m : getMusicians()) {
			m.addSong(song);
		}
	}

	/**
	 * Removes a song from all currently active musiceans.
	 */
	public void removeSong(Song song) {
		for(Musician m : getMusicians()) {
			m.removeSong(song);
		}
	}

	/**
	 * Returns all songs that can be played with the current roster of the
	 * band. 
	 *
	 * @return The songs that all currently active band members are able to
	 *         play.
	 */
	public Set<Song> getSongs() {
		return getSongs(null);
	}

	/**
	 * Returns all the songs at a given date as a set. 
	 * Only those songs are listed, that could have been be played with the 
	 * roster of the band at that date.
	 *
	 * @param at A past date.
	 * @return The songs that all band members at the given time were able to
	 *         play.
	 */
	public Set<Song> getSongs(Date date) {
		Set<Musician> roster = getMusicians(date); 
		Set<Song> set = new HashSet<Song>();

		for(Musician m : getMusicians(date)) {
			set.addAll(m.getSongs(date));
		}

		for(Musician m : getMusicians(date)) {
			set.retainAll(m.getSongs(date));
		}

		return set;
	}

	public List<Event> getEvents(){
		return events;
	}

	public List<Event> getEvents(Date from, Date to){
		return Event.filterFromTo(events, from, to);
	}

	public List<Event> getGigs(){
		List<Event> gigs = new ArrayList<Event>();
		for(Event e: events){
			if(e instanceof Gig){
				gigs.add(e);
			}
		}
		return gigs;
	}

	public List<Event> getGigs(Date from, Date to){
		return Event.filterFromTo(getGigs(), from, to);
	}

	public List<Event> getRehearsals(){
		List<Event> rehearsals = new ArrayList<Event>();
		for(Event e: events){
			if(e instanceof Rehearsal){
				rehearsals.add(e);
			}
		}
		return rehearsals;
	}

	public List<Event> getRehearsals(Date from, Date to){
		return Event.filterFromTo(getRehearsals(), from, to);
	}

	public int getBalance(List<Event> temp){
		int balance = 0;
		for(Event e : temp){
			balance += e.getIncome();
		}
		return balance;
	}

	public int getBalance(Date from, Date to){
		return getBalance(getEvents(from, to));
	}	

	public int getBalanceGigs(Date from, Date to){
		return getBalance(getGigs(from,to));
	}

	public int getBalanceRehearsals(Date from, Date to){
		return getBalance(getRehearsals(from,to));
	}
}
