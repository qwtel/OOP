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
	
	public Rehearsal(Rehearsal r) {
		super(r);
		this.rent = r.getIncome();
	}

	@Override
	public int getIncome() {
		return -rent;
	}
	
	public void setIncome(int income) {
		saveChange();
		rent = income;
	}

	@Override
	public String toString() {
		return super.toString() + " Rent: " + rent;
	}

	public void saveChange() {
		changeHist.add(new Rehearsal(this));	
	}
	@Override
	public boolean equals(Object o) {
		super.equals(o);
		if(rent == -(((Rehearsal) o).getIncome()))
			return true;
		return true;
	}
}
