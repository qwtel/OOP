import java.util.*;

/**
 * Provides methods to manage a band.
 *
 * @author Johannes Deml, Michael Ion, Florian Klampfer 
 */
public class Band {
	private String name;

	private List<Event> events;
	private List<Event> deletedEvents;
	private AssociationStorage<Musician> musicians;
	private List<Event> otherIncome;

	public Band(String name) {
		this.name = name;

		events = new ArrayList<Event>();
		musicians = new AssociationStorage<Musician>();
		otherIncome = new ArrayList<Event>();
		deletedEvents = new ArrayList<Event>();
	}
	
	/**
	 * @param e an instance of a subclass of Event
	 * Adds e to events and informs all musicians with a new
	 * EventProposal
	 */
	public void addEvent(Event e) {
		events.add(e);
		informMusicians(new EventProposal(e, "new"));
	}
	/**
	 * @param i
	 * i must be an instance of Income
	 */
	public void addOtherIncome(Event i) {
		otherIncome.add(i);
	}
	/*
	 * BAD: No method removeOtherIncome
	 */
	
	/**
	 * @param e an instance of a subclass of Event
	 * e must be in events
	 * changes Date in e and informs all musicians with a changed
	 * EventProposal
	 */
	public void changeEventDate(Event e, Date date) {
		events.remove(e);
		e.setDate(date);
		informMusicians(new EventProposal(e, "changed"));
		events.add(e);
	}

	/**
	 * @param e an instance of a subclass of Event
	 * e must be in events
	 * changes location in e and informs all musicians with a changed
	 * EventProposal
	 */
	public void changeEventLocation(Event e, String location) {
		events.remove(e);
		e.setLocation(location);
		informMusicians(new EventProposal(e, "changed"));
		events.add(e);
	}

	/**
	 * @param e an instance of a subclass of Event
	 * e must be in events
	 * changes duration in e and informs all musicians with a changed
	 * EventProposal
	 */	
	public void changeEventDuration(Event e, int duration) {
		events.remove(e);
		e.setDuration(duration);
		informMusicians(new EventProposal(e, "changed"));
		events.add(e);
	}

	/**
	 * @param e an instance of a subclass of Event
	 * e must be in events
	 * removes e and informs all musicians with a removed
	 * EventProposal
	 */
	public void removeEvent(Event e) {
		deletedEvents.add(e);
		informMusicians(new EventProposal(e, "removed"));
		events.remove(e);
	}
	
	/**
	 * @param e an Event Proposal on an Event with a corresponding status
	 * which must be "new", "changed" or "removed"
	 * Sends e to every musician stored in musicians
	 */
	public void informMusicians(EventProposal e) {
		for(Musician m : getMusicians()) {
			m.eventNotification(e);
		}
	}

	/**
	 * Gets, if possible, the response of every participating Musician on 
	 * a specific Event. If all musicians agree on an event, there is a positive command
	 * line output. If they disagree, there is a negative command line output.
	 */
	public boolean getMusiciansResponse(Event e) {
		boolean confirmation = true;

		for(Musician m : getMusicians()) {
			EventResponse ep = m.getResponse(e);
			confirmation = confirmation && ep.getDecision();
		}

		return confirmation;
	}

	/**
	 * Adds a new primary musician to this band. (postcondition)
	 *
	 * @see MusicianLogEntry
	 * @param musician A Musician that hasn't been added to the band before
	 *         (precondition).
	 */
	public void addMusician(Musician musician) {
		musicians.add(musician, new MusicianLogEntry(true));
	}

	/**
	 * Adds a musician with a given role (primary or secondary) to this band.
	 *         (postcondition)
	 *
	 * @see MusicianLogEntry
	 * @param musician A Musician that hasn't been added to the band before
	 * (precondition).
	 * @param isPrimary true for primary, false for secondary.
	 */
	public void addMusician(Musician musician, boolean isPrimary) {
		musicians.add(musician, new MusicianLogEntry(isPrimary));
	}

	/**
	 * Marks a musician as primary in this band. (postcondition)
	 *
	 * @see MusicianLogEntry
	 * @param musician A Musician that has been added to the band before
	 *         (precondition).
	 */
	public void markPrimary(Musician m) {
 		MusicianLogEntry meta = (MusicianLogEntry)musicians.getLogEntry(m);
		meta.isPrimary = true;
	}

	/**
	 * Marks a musician as secondary in this band. (postcondition)
	 *
	 * @see MusicianLogEntry
	 * @param musician A Musician that has been added to the band before
	 *         (precondition).
	 */
	public void markSecondary(Musician m) {
 		MusicianLogEntry meta = (MusicianLogEntry)musicians.getLogEntry(m);
		meta.isPrimary = false;
	}

	/**
	 * Removes a musician from the band.
	 *
	 * @see AssociationStorage
	 * @param musician A Musician that has been added to the band before
	 *         (precondition).
	 */
	public void removeMusician(Musician musician) {
		musicians.remove(musician);
	}

	public Set<Musician> getMusicians() {
		return musicians.getAt(null);
	}

	/**
	 * Returns all musicians to a given date.
	 *
	 * @param date A past date as Date object or null (precondition).
	 * @return All musicians (primary and secondary) that were active at the
	 *         given date. (postcondition)
	 */
	public Set<Musician> getAllMusicians(Date date) {
		return musicians.getAt(date);
	}

	/**
	 * Returns only the primary musicians. (postcondition)
	 *
	 * @param date A past date as Date object or null (precondition).
	 * @return Only the primary musicians that were active at the given date.
	 *         (postcondition)
	 */
	public Set<Musician> getMusicians(Date date) {
		Set<Musician> res = new HashSet<Musician>();

		for(Musician m : getAllMusicians(date)) {
			MusicianLogEntry meta = (MusicianLogEntry)musicians.getLogEntry(m);
			if(meta.isPrimary) {
				res.add(m);
			}
		}
		return res;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds a song to all currently active musicians. (postcondition)
	 *
	 * ERROR: If the song is already known by any of the band members, its
	 * LogEntry is replaced in the AssociationStorage. This should rather be
	 * prevented by code than by contract, since a client wouldn't expect 
	 * that a method like addSong could breaks something.
	 *
	 * NOTE: This method should probably be marked depricated since I only
	 * implemented it so that some tests from the pervious version still work. 
	 *
	 * @see AssociationStorage
	 * @param song A song, that is new to all currently active band member.
	 *         Consider using addSong for individual Musicians instead.
	 */
	public void addSong(Song song) {
		for(Musician m : getMusicians()) {
			m.addSong(song);
		}
	}

	/**
	 * Removes a song from all currently active musicians.
	 *
	 * NOTE: This forced me to write an additional if-statement in the remove
	 * method to test if the element was actually stored in the 
	 * AssociationStorage. This caused a NullPointerException. 
	 * See comment above.
	 *
	 * @see AssociationStorage
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
	 *		 play.
	 */
	public Set<Song> getSongs() {
		return getSongs(null);
	}

	/**
	 * Returns all the songs at a given date as a set. 
	 *
	 * @param date A past date as Date object or null (precondition).
	 * @return The songs that all band members were able to play at the given
	 *		 time. (postcondition)
	 */
	public Set<Song> getSongs(Date date) {
		Set<Song> set = new HashSet<Song>();

		for(Musician m : getMusicians(date)) {
			set.addAll(m.getSongs(date));
		}

		for(Musician m : getMusicians(date)) {
			set.retainAll(m.getSongs(date));
		}

		return set;
	}
	/*
	 * NOTE: Class got really huge. It would have been a good Idea to 
	 * pull out some of the Code and put it in an other Class, just for
	 * a better legibility. 
	 */
	public List<Event> getEvents() {
		return events;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 */
	public List<Event> getEvents(Date from, Date to) {
		return Event.filterFromTo(events, from, to);
	}
	
	public List<Event> getDeletedEvents() {
		return deletedEvents;
	}

	public List<Event> getGigs() {
		List<Event> gigs = new ArrayList<Event>();
		for(Event e: events) {
			if(e instanceof Gig) {
				gigs.add(e);
			}
		}
		return gigs;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 */	
	public List<Event> getGigs(Date from, Date to) {
		return Event.filterFromTo(getGigs(), from, to);
	}

	public List<Event> getRehearsals() {
		List<Event> rehearsals = new ArrayList<Event>();
		for(Event e: events){
			if(e instanceof Rehearsal) {
				rehearsals.add(e);
			}
		}
		return rehearsals;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 */
	public List<Event> getRehearsals(Date from, Date to) {
		return Event.filterFromTo(getRehearsals(), from, to);
	}
	
	public List<Event> getOtherIncome() {
		return otherIncome;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 */	
	public List<Event> getOtherIncome(Date from, Date to) {
		return Event.filterFromTo(otherIncome, from, to);
	}
	
	public List<Event> getAllBills() {
		List<Event> allIncome = new ArrayList<Event>(events);
		allIncome.addAll(otherIncome);
		return allIncome;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 */	
	public List<Event> getAllBills(Date from, Date to) {
		return(Event.filterFromTo(getAllBills(), from, to));
	}
	
	/*
	 * GOOD: We're able to do all the balancing stuff
	 * with Lists of Events (Gigs, Rehearsals and Income)
	 * which all have the methods getDate and getIncome
	 */
	public int getBalance(List<Event> temp) {
		int balance = 0;
		for(Event e : temp) {
			balance += e.getIncome();
		}
		return balance;
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 * @return the balance (sum) of all Events within
	 * two Dates Either positive or negative Integer
	 */
	public int getBalance(Date from, Date to) {
		return getBalance(getEvents(from, to));
	}	
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 * @return the balance (sum) of all Gigs within
	 * two Dates Either positive or negative Integer
	 */
	public int getBalanceGigs(Date from, Date to) {
		return getBalance(getGigs(from,to));
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 * @return the balance (sum) of all Rehearsals within
	 * two Dates Either positive or negative Integer
	 */
	public int getBalanceRehearsals(Date from, Date to) {
		return getBalance(getRehearsals(from,to));
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 * @return the balance (sum) of all other Income
	 * (saved in EventList OtherIncome) within
	 * two Dates Either positive or negative Integer
	 */
	public int getBalanceOtherIncome(Date from, Date to) {
		return getBalance(getOtherIncome(from,to));
	}
	/**
	 * NTOE: The Income from Events at the exact Date 
	 * from and to are not included
	 * @return the balance (sum) of all Income and outcome
	 *  within two Dates Either positive or negative Integer
	 */
	public int getBalanceAllBills(Date from, Date to) {
		return getBalance(getAllBills(from,to));
	}
}
