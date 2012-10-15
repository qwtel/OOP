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
			if(e instanceof Gig)
				balance += e.getGage();
			else
				balance -= e.getRent();
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
