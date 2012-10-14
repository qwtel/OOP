import java.util.*;

public class Test{
	public static void main(String[] args){
		try {
			Date a1 = new Date();
			Thread.sleep(1);
			Date a = new Date();
			Song song1 = new Song("Energy Wizard", 225);
			Song song2 = new Song("Brain Damage", 230);
			Song song3 = new Song("Contrapunctus 11", 350);
			Gig gig1 = new Gig("Volksoper", a, 3500, 120);
			Rehearsal rehearsal1 = new Rehearsal("Mamas Keller", a, 1750, 50);
			Band band = new Band();
			band.addSong(song1);
			band.addEvent(gig1);
			/*
			 * HACK: Ensuring that dates are unique. 
			 * This is not a real issue, since songs will not be added and
			 * removed within 1 millisecond.
			 */
			Thread.sleep(1);

			band.addSong(song2);
			Date b0 = new Date();
			Thread.sleep(1);

			Date b = new Date();
			Thread.sleep(1);
			Date b1 = new Date();
			Gig gig2 = new Gig("Seitengasse", b, 5000, 500);
			Rehearsal rehearsal2 = new Rehearsal("Dorftheater", b, 2500, 20);

			band.addSong(song3);
			Thread.sleep(1);

			band.removeSong(song2);
			Thread.sleep(1);

			System.out.println(band.getSongs()); //song 1 and 3
			System.out.println(band.getSongs(b)); // song 1 and 2
			
			Thread.sleep(1);
			Date c = new Date();
			Thread.sleep(1);
			Date c1 = new Date();
			Gig gig3 = new Gig("Arena", c, 6000, 120);
			Rehearsal rehearsal3 = new Rehearsal("Audimax", c, 1500, 45);
			band.addEvent(gig2);
			band.addEvent(gig3);
			band.addEvent(rehearsal1);
			band.addEvent(rehearsal2);
			band.addEvent(rehearsal3);

			List<Event> events1 = new ArrayList<Event>(band.getEvents(b0, c1));//gig2, rehearsal2, gig3, rehearsal3
			List<Event> events2 = new ArrayList<Event>(band.getEvents());//all events
			List<Event> gigs1 = new ArrayList<Event>(band.getGigs(a1, b1));//gig1, gig2
			List<Event> rehearsals1 = new ArrayList<Event>(band.getRehearsals(a, null)); //rehearsal 2,3
			for(Event e: events1){
				System.out.println(e.toString());
			}
			for(Event e: events2){
				System.out.println(e.toString());
			}
			for(Event e: gigs1){
				System.out.println(e.toString());
			}
			for(Event e: rehearsals1){
				System.out.println(e.toString());
			}

		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
