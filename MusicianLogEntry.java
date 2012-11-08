/**
 * A specific log entry for storing musicians.
 *
 * GOOD: This inherites all the functionality of LogEntry (storing start and end
 * dates) and can therefor be used whereever a normal LogEntry can be used.
 *
 * @author Florian Klampfer
 */
public class MusicianLogEntry extends LogEntry {
	public boolean isPrimary;

	public MusicianLogEntry(boolean isPrimary) {
		super();
		this.isPrimary = isPrimary;
	}
}
