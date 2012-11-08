/**
*@author Michael Ion
*/
public class Song {
	private final String name;
	private final int duration;
	/**
	 * Creates a new Song object
	 * @param name the name of the Song
	 * @param duration the duration of the Song, must be a positive value
	 */
	public Song(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}
	
	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Name: "+name+" Duration: "+duration;
	}
}   
