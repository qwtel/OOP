import java.util.*;

/**
 * Used to inform musicians about new, changed or removed Events
 *
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

	public Event getEvent() {
		return e;
	}

	public String getStatus() {
		return status;
	}
	
	public String toString(){
		return e.toString() + "status: " + status;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof EventProposal) {
			if(getEvent().equals(((EventProposal) o).getEvent()) && getStatus().equals(((EventProposal) o).getStatus()))
				return true;
		}
		return false;
	}

}
