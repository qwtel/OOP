import java.util.Date;

/**
 * Income.java
 *
 * @author Johannes Deml
 * @version 1.2 - Oct 20, 2012
 * @since 1.2
 */
public class Income implements IncomeInterface {
	private int income;
	private Date date;
	public Income(int income, Date date)
	{
		this.income = income;
		this.date = date;
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
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
}