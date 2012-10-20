/**
 * Income.java
 *
 * @author Johannes Deml
 * @version 1.2 - Oct 20, 2012
 * @since 1.2
 */
public class Income implements IncomeInterface {
	private int income;
	public Income(int income)
	{
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
	
}
