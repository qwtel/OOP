import java.util.*;

/**
 * Stores items of a certain type together with additional information.
 * The 'additional information' is an object of type LogEntry, which stores the
 * date of entry and removal from the storage.
 *
 * GOOD: An AssociationStorage can store meta-information (start and end
 * dates per default) to any object without knowing anything about those
 * objects. Weak object coupling.
 *
 * @see LogEntry
 * @author Florian Klampfer
 */
public class AssociationStorage<E> {

	/*
	 * This set will always contain all elements that have ever been added to
	 * the AssociationStorage. The size of the set can't become smaller
	 * (history constraint).
	 */
	private Set<E> set;
	private Map<E, LogEntry> log;

	public AssociationStorage() {
		set = new HashSet<E>();
		log = new HashMap<E, LogEntry>();
	}

	/**
	 * Adds an item to the set and creates an entry in the log.
	 * (postcondition)
	 *
	 * @param e The item to be added to the set. The item must not be contained
	 *         in the AssociationStorage (precondition).
	 */
	public void add(E e) {
		LogEntry logEntry = new LogEntry();
		log.put(e, logEntry);
		set.add(e);
	}

	/**
	 * Adds an item to the set and puts the given entry in the log.
	 * (postcondition)
	 *
	 * @param e The item to be added to the set. The item must not be contained
	 *         in the AssociationStorage (precondition).
	 * @param customLogEntry A sub class of LogEntry that can provide additional
	 *         information about the item.
	 *
	 * BAD: This method and exposes details about the implementation of the
	 * AssociationStorage to the client and assumes that he has knowledge about
	 * it, so that he can provide a custom LogEntry (which should rather be a
	 * private class?) 
	 * Better: A subclass like MusicianAssociationStorage, maybe?
	 */
	public void add(E e, LogEntry customLogEntry) {
		log.put(e, customLogEntry);
		set.add(e);
	}

	/**
	 * Returns the log entry (meta information) for the given element.
	 *
	 * @param e An element that must have been added to the AssociationStorage
	 *         before (precondition).
	 * @return The LogEntry containing meta information for the given element.
	 *         (postcondition)
	 */
	public LogEntry getLogEntry(E e) {
		return log.get(e);
	}

	/**
	 * Pseudo-removes an item from the set and updates the entry in the log.
	 * (postcondition)
	 *
	 * The actual element will remain within the AssociationStorage and can be
	 * retrieved by providing a date at which the element was active to 
	 * getAt (invariant).
	 *
	 * @param e An element that has been stored in the AssociationStorage
	 * before (precondition).
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
	 * @param date A past date as Date object or null (precondition).
	 * @return The active list items to a given date or the currently active
	 *		 items if no date was provided. (postcondition)
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
