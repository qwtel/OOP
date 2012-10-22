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
		this.status = "new";
	}

	public Event getEvent() {
		return e;
	}

	public String getStatus() {
		return status;
	}
}
