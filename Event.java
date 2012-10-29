import java.util.*;

/**
 * Abstract Class which stores a location, a date and duration for an Event.
 * @param location: the location of the Event
 * @param date: the date of the Event
 * @param duration: the duration of the Event 
 * @author Johannes Deml, Michael Ion
 */
public abstract class Event {
	String location;
	private Date date;
	private int duration;

	/**
	 * A list containing all changes of this Event
	 */
	protected List<Event> changeHist;
	
	/**
	 * 
	 * @param date
	 */
	public Event(Date date) {
		this.date=date;
	}
	/**
	 * Creates a new Event with the specified values
	 * @param duration: must be a positive value
	 */
	public Event(String location, Date date, int duration)
	{
		this(date);
		this.location = location;
		this.duration = duration;
		this.changeHist = new ArrayList<Event>();
	}
	/**
	 * Creates a new Event as a clone of a given Event
	 * @param e the basis for the new Event
	 */
	public Event(Event e) {
		this.location = e.getLocation();
		this.date = e.getDate();
		this.duration = e.getDuration();
		this.changeHist = new ArrayList<Event>();
	}
	/**
	 * @return the location of this Event
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Changes the location of this Event and saves a copy of the unchanged Event.
	 * @param location the new location of the event
	 */
	public void setLocation(String location) {
		saveChange();
		this.location = location;
	}
	/**
	 * @return the date of this Event
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * Changes the date of this Event and saves a copy of the unchanged Event.
	 * @param location the new date of the event
	 */
	public void setDate(Date date) {
		saveChange();
		this.date = date;
	}
	/**
	 * @return the duration of this Event
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * Changes the duration of this Event and saves a copy of the unchanged Event.
	 * @param location the new duration of the event; must be a positive value
	 */
	public void setDuration(int duration) {
		saveChange();
		this.duration = duration;
	}
	/**
	 * provides a method to add a duplicate of this Event
	 * to changeHist
	 * 
	 * BAD: could be fully implemented, saving code in all subclasses
	 */
	public abstract void saveChange();

	/**
	 * Returns a copy of changeHist consisting of all changed Events
	 */
	public List<Event> getChangeHist() {
		List<Event> temp = new ArrayList<Event>();
		for(Event e : changeHist) {
			temp.add(e);
		}
		return temp;
	}
	/**
	 * GOOD: demands from the subclass an implementation of a method to return
	 * income (calls in a context where event is used -e.g. Data Structures- the
	 * subclasses' method through dynamic binding, making it easier to gather the amount
	 * of incomes from all events)
	 */
	public abstract int getIncome();
	//BAD: an abstract method setIncome would be a good idea as it goes hand in hand with getIncome

	/**
	 * Creates a List consisting of events which occurred during a given time frame.
	 * If one date is missing (= null), the other one is the indicator for validity.
	 * If both are missing, it returns the whole list.
	 * 
	 * @param events List of Events
	 * @param from The beginning date of the specified time frame; must be older than to
	 * @param to The end date of the specified time frame.
	 * @return list of events inside the time frame
	 *
	 * @author Michael Ion
	 */
	public static List<Event> filterFromTo(List<Event> events, Date from, Date to) {
		List<Event> res = new ArrayList<Event>();
		if( from == null && to == null)
			return events;
		for(Event e : events){
			if(from == null){
				if(to.after(e.getDate()))
					res.add(e);
			}
			else if(to == null){
				if(from.before(e.getDate()))
					res.add(e);
			}
			else if(from.before(e.getDate()) && to.after(e.getDate()))
				res.add(e);		
		}
		return res;
	}
	/**
	 * Checks if an object is equal to this event;
	 * returns true if the object is an instance of Event and
	 * location, date and duration are equal.
	 * 
	 * GOOD: this method is called from the equals functions in all
	 * subclasses, which results in less code (because the subclasses don't
	 * have to check all variables)
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Event) {
			if(location.equals(((Event) o).getLocation())) {
				if(date.equals(((Event) o).getDate())) {
					if(duration == (((Event) o).getDuration())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * @param return a String consisting of the contents of this Event
	 */
	@Override
	public String toString() {
		return date.toString()+": Ort: "+location+" Dauer: "+duration;
	}
}
