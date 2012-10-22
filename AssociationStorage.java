import java.util.*;

/**
 * Stores items of a certain type together with additional information.
 * The 'additional information' is an object of type LogEntry, which stores the
 * date of entry and removal from the storage.
 *
 * @see LogEntry
 * @author Florian Klampfer
 */
public class AssociationStorage<E> {
	private Set<E> set;
	private Map<E, LogEntry> log;

	public AssociationStorage() {
		set = new HashSet<E>();
		log = new HashMap<E, LogEntry>();
	}

	/**
	 * Adds an item to the set and creates an entry in the log.
	 *
	 * @param e The item to be added to the set.
	 */
	public void add(E e) {
		LogEntry logEntry = new LogEntry();
		log.put(e, logEntry);
		set.add(e);
	}

	/**
	 * Adds an item to the set and puts the given entry in the log.
	 *
	 * @param e The item to be added to the set.
	 * @param customLogEntry A sub class of LogEntry that can provide additional
	 *         information about the item.
	 */
	public void add(E e, LogEntry customLogEntry) {
		log.put(e, customLogEntry);
		set.add(e);
	}

	/**
	 * Returns the log entry (meta information) for the given element.
	 */
	public LogEntry getLogEntry(E e) {
		return log.get(e);
	}

	/**
	 * Pseudo-removes an item from the set and updates the entry in the log.
	 */
	public void remove(E e) {
		LogEntry logEntry;
		if((logEntry = log.get(e)) != null) {
			logEntry.end();
		}
	}

	/**
	 * Returns the active items from the set based on a given date and the log.
	 * If no date is provided (= null) the currently active elements will be
	 * returned.
	 *
	 * @param list The list to be filtered.
	 * @param d A past date as Date object or null
	 * @return The active list items to a given date or the currently active
	 *		 items if no date was provided.
	 */
	public Set<E> getAt(Date date) {
		Set<E> res = new HashSet<E>();
		for (E e : set) {
			if (log.get(e).isActive(date)) {
				res.add(e);
			}
		}
		return res;
	}
}
