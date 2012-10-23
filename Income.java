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
	public Income(int income, Date date) {
		super(date);
		this.income = income;
	}

	/**
	 * @return the income
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(int income) {
		this.income = income;
	}
	@Override
	public void saveChange() {
		// TODO Auto-generated method stub
		
	}
}
