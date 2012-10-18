import java.util.*;

/**
 * @author Florian Klampfer
 */
public class Rehearsal extends Event {
	private int rent;
	public Rehearsal(String location, Date date, int duration, int rent) {
		super(location, date, duration);
		this.rent = rent;
	}

	@Override
	public int getIncome() {
		return -rent;
	}
}
