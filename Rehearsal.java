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
	/**
	 * Sets rent to the value of income and saves the change.
	 * @param income must be a positive value
	 */
	public void setIncome(int income) {
		saveChange();
		rent = income;
	}

	@Override
	public String toString() {
		return super.toString() + " Rent: " + rent;
	}
	/**
	 * adds a duplicate of this Rehearsal to changeHist
	 */
	public void saveChange() {
		changeHist.add(new Rehearsal(this));	
	}
	/**
	 * Checks if an object is equal to this Rehearsal
	 * returns true if equals from the superclass returns true
	 * and income is equal
	 * 
	 * GOOD: Through dynamic binding, this method is called in every
	 * situation (e.g. in Data Structures) where only Event is specified,
	 * which results in saved code lines (calls superclass)
	 * 
	 * ERROR: The method doesn't fulfill its functionality, because it
	 * returns true in all cases;
	 * Also, only rent is checked on equality:
	 * if-Statement should be if(super.equals(o) && rent == -(((Rehearsal) o).getIncome()))
	 * (all tests with a corrected version still pass)
	 */
	@Override
	public boolean equals(Object o) {
		super.equals(o);
		if(rent == -(((Rehearsal) o).getIncome()))
			return true;
		return true;
	}
}
