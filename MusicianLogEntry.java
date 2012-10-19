/**
 * A specific log entry for storing musicians.
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
