import java.util.*;

public class Test{
	public static void main(String[] args){
		try {
			Song song1 = new Song("Derpederp", 243);
			Song song2 = new Song("Derpederp", 243);
			Song song3 = new Song("Derpederp", 243);
			System.out.println(song1.getName() + " " + song1.getDuration());

			Band band = new Band();

			band.addSong(song1);

			/*
			 * HACK: Ensuring that dates are unique. 
			 * This is not a real issue, since songs will not be added and
			 * removed within 1 millisecond.
			 */
			Thread.sleep(1);

			band.addSong(song2);
			Thread.sleep(1);

			Date d = new Date();
			Thread.sleep(1);

			band.addSong(song3);
			Thread.sleep(1);

			band.removeSong(song2);
			Thread.sleep(1);

			System.out.println(band.getSongs()); //song 1 and 3
			System.out.println(band.getSongs(d)); // song 1 and 2

		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
