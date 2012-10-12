/**
*@author Michael Ion
*/
public class Gig extends Event{
	public gig(String location, Date date, int duration, int gage){
		super(String location, Date date, int duration);
		this.gage = gage;
	}
	private int gage;
	public int getGage(){
		return gage;
	}
	public String toString(){
		return super.toString() + gage;
	}
}
