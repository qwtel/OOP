/**
*@author Michael Ion
*/
public class Song{
	public Song(String name, int duration){
		this.name = name;
		this.duration = duration;
	}
	private final String name;
	private final int duration;
	
	public String getName(){
		return name;
	}
	
	public int getDuration(){
		return duration;
	}
	
}
