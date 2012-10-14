import java.util.*;

/**
 * Encapsulates start and end dates.
 * @author Florian Klampfer
 */
class LogEntry {
	public Date start;
	public Date end;

	public LogEntry() {
		this.start = new Date();
		this.end = null;
	}

	/**
	 * Marks this entry as inactive.
	 */
	public void end() {
		this.end = new Date();
	}

	/**
	 * Checks if the entry was active to a given date.
	 * If no date is provided (= null) checks if the entry is currently active.
	 *
	 * @param d A past date as Date object or null.
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
