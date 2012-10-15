import java.util.*;

/**
 * @author Florian Klampfer
 */
class Rehearsal extends Event {
	private int rent;
	public Rehearsal(String location, Date date, int duration, int rent) {
		super(location, date, duration);
		this.rent = rent;
	}

	public int getIncome() {
		return -rent;
	}
}
