import java.util.*;

/**
 * @author Michael Ion
 */
public class Gig extends Event {
	private int gage;

	public Gig(String location, Date date, int duration, int gage) {
		super(location, date, duration);
		this.gage = gage;
	}
	
	public Gig(Gig g) {
		super(g);
		this.gage = g.getIncome();
	}

	public int getIncome() {
		return gage;
	}

	public String toString() {
		return super.toString() + gage;
	}
	/**
	 * Sets gage to the value of income and saves the change.
	 * @param income must be a positive value
	 */
	public void setIncome(int income) {
		saveChange();
		gage = income;
	}
	/**
	 * adds a duplicate of this Gig to changeHist
	 */
	public void saveChange() {
		Gig temp = new Gig(getLocation(), getDate(), getDuration(), getIncome());
		changeHist.add(new Gig(temp));	
	}
	/**
	 * Checks if an object is equal to this Gig
	 * returns true if equals from the superclass returns true
	 * and income is equal
	 * 
	 * GOOD: Through dynamic binding, this method is called in every
	 * situation (e.g. in Data Structures) where only Event is specified,
	 * which results in saved code lines (calls superclass)
	 * 
	 * ERROR: The method doesn't fulfill its functionality, because only income is
	 * checked on equality:
	 * if-Statement should be if(super.equals(o) && gage == (((Gig) o).getIncome()))
	 * (all tests with a corrected version still pass)
	 */
	public boolean equals(Object o) {
		super.equals(o);
		if(gage == (((Gig) o).getIncome()))
			return true;
		return false;
	}
}
