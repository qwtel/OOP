import java.util.*;

/**
 * @author Michael Ion
 */
public class Gig extends Event{
	public Gig(String location, Date date, int duration, int gage){
		super(location, date, duration);
		this.gage = gage;
	}
	private int gage;
	public int getIncome(){
		return gage;
	}
	public String toString(){
		return super.toString() + gage;
	}
	public void setIncome(int income) {
		gage = income;
		
	}
}
