import java.util.*;

/**
 * Provides basic methods to manage a musician.
 *
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

	/**
	 * @see AssociationStorage
	 */
	public void addSong(Song song) {
		songs.add(song);
	}

	/**
	 * @see AssociationStorage
	 */
	public void removeSong(Song song) {
		songs.remove(song);
	}

	/**
	 * @see AssociationStorage
	 */
	public Set<Song> getSongs() {
		return songs.getAt(null);
	}

	/**
	 * @see AssociationStorage
	 */
	public Set<Song> getSongs(Date date) {
		return songs.getAt(date);
	}
	
	/**
	 * @param e the specific event we want a response on
	 * @return returns the response if there is one on e in responses; else returns a negative response
	 */
	public EventResponse getResponse(Event e) {
		for(EventResponse r : responses){
			if(r.getEvent().equals(e))
				return r;
		}
		return new EventResponse(e, false, "No current response");
	}
	/**
	 * adds a new Response to responses
	 * @param e the Event on which a Response is created on
	 * @param decision a boolean which represents the decision of the musician
	 * on the Event (negative decision == false; positive decision == true)
	 * @param message a String to clarify the decision
	 * message and decision should be coherent and reasonable (e.g. if the message is "Sounds good,
	 * I have time!" and decision == false is not reasonable and confusing)
	 */
	public void addResponse(Event e, boolean decision, String message) {
		responses.add(new EventResponse(e, decision, message));
	}

	/**
	 * Musician sees changed or removed Event entries
	 * on Notification List
	 * @param e an EventProposal on a changed or removed Event entry
	 */
	public void eventNotification(EventProposal e) {
		proposals.add(e);
	}
	/**	
	 * @return a reference on a list with the collected EventProposals
	 */
	public List<EventProposal> getProposals() {
		return proposals;
	}

	@Override
	public String toString() {
		return "Name: "+name+" Tel: "+tel+" Ins: "+instrument;

	}
}
