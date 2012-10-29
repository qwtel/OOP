import java.util.Date;

/**
 * The most basic form of meta information stored together with an item in the
 * AssociationStorage.
 *
 * @see AssociationStorage
 * @author Florian Klampfer
 */
public class LogEntry {
	/*
	 * ERROR: These should be private. (maybe even final?) They should only be
	 * set by the constructor and the end method, since the
	 * contract/history-constraint that is suggested by their names (that end 
	 * is always a date after start [or null]) could otherwise be violated.
	 */
	public Date start;
	public Date end;

	/**
	 * Creates a new LogEntry.
	 * This will implicitly set it's start date to the current time. 
	 * (postcondition)
	 */
	public LogEntry() {
		this.start = new Date();
		this.end = null;
	}

	/**
	 * Marks this entry as inactive. 
	 * This will set the end date to the current time. (postcondition)
	 */
	public void end() {
		this.end = new Date();
	}

	/**
	 * Checks if the entry was active to a given date.
	 * If no date is provided (= null) checks if the entry is currently
	 * active.
	 *
	 * @param d A past date as Date object or null. (precondition)
	 * @return True if the item was active at the given time if a date was
	 * provided. True if the item is currently active if no date was provided 
	 * (postcondition)
	 */
	public boolean isActive(Date d) {
		if (d == null) {
			return (end == null);
		}

		if (end == null) {
			return start.before(d);
		}

		return start.before(d) && end.after(d);
	}
}
