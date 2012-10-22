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

	public void setIncome(int income) {
		saveChange();
		gage = income;
	}
	
	public void saveChange() {
		Gig temp = new Gig(getLocation(), getDate(), getDuration(), getIncome());
		changeHist.add(new Gig(temp));	
	}
	
	public boolean equals(Object o) {
		super.equals(o);
		if(gage == (((Gig) o).getIncome()))
			return true;
		return false;
	}
}
