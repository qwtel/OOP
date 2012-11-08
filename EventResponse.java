/**
 * A class which stores a decision in form of a boolean on an Event,
 * with a corresponding message explaining that decision
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
	/**
	 * @return a reference on the Event
	 */
	public Event getEvent() {
		return e;
	}
	/**
	 * @return the decision on the Event in form of a boolean
	 */
	public boolean getDecision() {
		return decision;
	}
	/**
	 * @return a reference on the stored message
	 */
	public String getMessage() {
		return message;
	}
}
