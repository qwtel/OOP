import java.util.Date;

/**
 * Billable.java
 *
 * @author Johannes Deml
 * @version 1.2
 * @since 1.2 - Oct 22, 2012
 */
public interface Billable {
	public int getIncome();
	public void setIncome(int income);
	public Date getDate();
	public void setDate(Date date);
}
