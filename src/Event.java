import java.util.*;

/**
 * 
 * Abstract Class for Appearances and Reahearsals
 * @author Johannes Deml
 *
 */
public abstract class Event {
	
	public Event(String location, Date date, int duration)
	{
		this.location = location;
		this.date = date;
		this.duration = duration;
	}
	private String location;
	private Date date;
	private int duration;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * Creates a List consisting of events which occurred during a given time frame.
	 * If one date is missing (= null), the other one is the indicator for validity.
	 * If both are missing, it returns the whole list.
	 * @param events List of Events
	 * @param from The beginning date of the specified time frame.
	 * @param to The end date of the specified time frame.
	 * @return list of events inside the time frame
	 * @author Michael Ion
	 */
	public static List<Event> filterFromTo(List<Event> events, Date from, Date to){
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
	
	
	public String toString()
	{
		return date.toString()+": Ort: "+location+" Dauer: "+duration;
	}
}
