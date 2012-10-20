import java.util.*;

/**
 * Provides basic methods to manage a musician.
 * @author Florian Klampfer
 */
public class Musician {
	private final String name;
	private final String tel;
	private final String instrument;
	
	private List<EventProposal> proposals;
	private List<EventResponse> responses;
	private AssociationStorage<Song> songs;

	public Musician(String name, String tel, String instrument) {
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
		this.songs = new AssociationStorage<Song>();
		this.proposals = new ArrayList<EventProposal>();
		this.responses = new ArrayList<EventResponse>();
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
	
	/*
	 * Returns a response on a specific Event. If there is none,
	 * the Response returns false with a "No current response" message
	 */
	public EventResponse getResponse(EventProposal e) {
		for(EventResponse r : responses){
			if(r.getEvent().equals(e.getEvent()))
				return r;
		}
		return new EventResponse(e.getEvent(), false, "No current response");
	}
	
	public void addResponse(Event e, boolean decision, String message) {
		responses.add(new EventResponse(e, decision, message));
	}
	/*
	 * Musician sees changed or removed Event entries
	 * on Notification List
	 */
	public void eventNotification(EventProposal e) {
		proposals.add(e);
	}

	@Override
	public String toString() {
		return "Name: "+name+" Tel: "+tel+" Ins: "+instrument;

	}
}
