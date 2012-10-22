import java.util.*;

/**
 * Used to give musicians a possibility to response on a possible new Event date
 *
 * @author Michael Ion
 * @version 1.0
 * @since 1.0 - Oct 20, 2012
 */
public class EventResponse {
	private Event e;
	private boolean decision;
	private String message;

	public EventResponse(Event e, boolean decision, String message) {
		this.e = e;
		this.decision = decision;
		this.message = message;
	}

	public Event getEvent() {
		return e;
	}

	public boolean getDecision() {
		return decision;
	}

	public String getMessage() {
		return message;
	}
}
