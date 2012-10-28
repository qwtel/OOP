/**
 * A class which stores a proposal on an Event 
 * with a corresponding status of the Event
 * @param status must be "new", "changed" or "removed"
 * @author Michael Ion
 * @version 1.0
 * @since 1.0 - Oct 20, 2012
 */
public class EventProposal {
	private Event e;
	private String status;

	public EventProposal(Event e, String status) {
		this.e = e;
		this.status = status;
	}
	/**
	 * @return a reference on the Event
	 */
	public Event getEvent() {
		return e;
	}
	/**
	 * @return the status on the Event which is either "new", "changed" or "removed"
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return a String with the contents of this object
	 */
	public String toString(){
		return e.toString() + "status: " + status;
	}
	@Override
	/**
	 * checks if an Object o is equal to this
	 * can take any Object as an argument; only returns true if o is an instance of
	 * EventProposal and the contents are equal 
	 */
	public boolean equals(Object o) {
		if(o instanceof EventProposal) {
			if(getEvent().equals(((EventProposal) o).getEvent()) && getStatus().equals(((EventProposal) o).getStatus()))
				return true;
		}
		return false;
	}

}
