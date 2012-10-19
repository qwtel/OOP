import java.util.*;

/**
 * An ArrayList that keeps track of added and removed items.
 * @author Florian Klampfer
 */
public class LoggedArrayList<E> {
	private Set<E> set;
	private Map<E, LogEntry> log;

	public LoggedArrayList() {
		set = new HashSet<E>();
		log = new HashMap<E, LogEntry>();
	}

	/**
	 * Adds an item to a list and creates an entry in the log.
	 */
	public void add(E e) {
		LogEntry logEntry = new LogEntry();
		log.put(e, logEntry);
		set.add(e);
	}

	/**
	 * Pseudo-removes an item from a list and updates the entry in the log.
	 */
	public void remove(E e) {
		LogEntry logEntry = log.get(e);
		logEntry.end();
	}

	/**
	 * Returns the active items of a list based on a given date and the log.
	 * If no date is provided (= null) the currently active elements will be
	 * returned.
	 *
	 * @param list The list to be filtered.
	 * @param d A past date as Date object or null
	 * @return The active list items to a given date or the currently active
	 *         items if no date was provided.
	 */
	public Set<E> getAt(Date date) {
		Set<E> res = new HashSet<E>();
		for (E e : set) {
			LogEntry logEntry = log.get(e);
			if (logEntry.isActive(date)) {
				res.add(e);
			}
		}
		return res;
	}

	/**
	 * Encapsulates start and end dates.
 	 * @author Florian Klampfer
	 */
	private class LogEntry {
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
		 * If no date is provided (= null) checks if the entry is currently
		 * active.
		 *
		 * @param d A past date as Date object or null.
		 * @return true if the item was active at the given time.
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
}
