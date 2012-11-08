import java.util.Date;

/**
 * Income.java
 *
 * @author Johannes Deml
 * @version 1.2 - Oct 20, 2012
 * @since 1.2
 */
public class Income extends Event {
	private int income;
	/**
	 * BAD:
	 * Missing Parameters: location, duration -> could lead to errors
	 * but are useless for Income
	 * Income extends Event, but uses only the
	 * Date and getIncome() to make it possible to use Income 
	 * in Eventlists (in Band). A Superclass from which Event and
	 * income are extended would be more elegant.
	 */
	public Income(int income, Date date) {
		super(date);
		this.income = income;
	}

	/**
	 * @return the income
	 * Value can be either positive or negative
	 * 0 wouldn't make any sense
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 * Income should not be 0
	 */
	public void setIncome(int income) {
		this.income = income;
	}
	@Override
	public void saveChange() {
		// TODO Auto-generated method stub
		
	}
}
