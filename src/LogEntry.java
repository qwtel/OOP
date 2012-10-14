import java.util.*;

/**
 * Encapsulates time.
 * @author Florian Klampfer
 */
class LogEntry {
	public Date start;
	public Date end;

	public LogEntry() {
		this.start = new Date();
		this.end = null;
	}

	public void end() {
		this.end = new Date();
	}

	public boolean isActive() {
		return (end == null);
	}

	public boolean wasActive(Date d) {
		if (end == null) {
			return start.before(d);
		}
		return start.before(d) && end.after(d);
	}
}
