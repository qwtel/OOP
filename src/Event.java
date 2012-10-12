import java.util.*;
/**
 * 
 * Abstract Class for Appearances and Reahearsals
 * @author Johannes Deml
 *
 */
public abstract class Event {
	private String location;
	private Date date;
	private int duration;
	public Event(String location, Date date, int duration)
	{
		this.location = location;
		this.date = date;
		this.duration = duration;
	}
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
}
