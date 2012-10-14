import java.util.*;

/**
 * An ArrayList that keeps track of added and removed items.
 * @author Florian Klampfer
 */
class LoggedArrayList<E> extends ArrayList<E> {
	private Map<E, LogEntry> log;

	public LoggedArrayList() {
		log = new HashMap<E, LogEntry>();
	}

	/**
	 * Adds an item to a list and creates an entry in the log.
	 */
	@Override
	public boolean add(E e) {
		LogEntry logEntry = new LogEntry();
		log.put(e, logEntry);
		return super.add(e);
	}

	/**
	 * Pseudo-removes an item from a list and updates the entry in the log.
	 */
	public void markInactive(E e) {
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
	public List<E> getAll(Date at) {
		List<E> res = new ArrayList<E>();
		for (E e : this) {
			LogEntry logEntry = log.get(e);
			if (logEntry.isActive(at)) {
				res.add(e);
			}
		}
		return res;
	}

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
		 * If no date is provided (= null) checks if the entry is currently
		 * active.
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
}
