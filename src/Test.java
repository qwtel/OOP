import java.util.*;

/**
 * Quick and dirty test class
 * @author Johannes Deml, Michael Ion, Florian Klampfer 
 */
public class Test{
	public static void main(String[] args){
		Date a1 = new UniqueDate();
		Date a = new UniqueDate();

		Song song1 = new Song("Energy Wizard", 225);
		Song song2 = new Song("Brain Damage", 230);
		Song song3 = new Song("Contrapunctus 11", 350);

		Gig gig1 = new Gig("Volksoper", a, 3500, 120);
		Rehearsal rehearsal1 = new Rehearsal("Mamas Keller", a, 1750, 50);

		Band band = new Band();

		band.addSong(song1);
		band.addEvent(gig1);
		Date sleep = new UniqueDate();

		band.addSong(song2);
		Date b0 = new UniqueDate();
		Date b = new UniqueDate();
		Date b1 = new UniqueDate();
		Gig gig2 = new Gig("Seitengasse", b, 5000, 500);
		Rehearsal rehearsal2 = new Rehearsal("Dorftheater", b, 2500, 20);

		band.addSong(song3);
		sleep = new UniqueDate();

		band.removeSong(song2);
		sleep = new UniqueDate();

		Date c = new UniqueDate();
		Date c1 = new UniqueDate();
		Gig gig3 = new Gig("Arena", c, 6000, 120);
		Rehearsal rehearsal3 = new Rehearsal("Audimax", c, 1500, 45);
		band.addEvent(gig2);
		band.addEvent(gig3);
		band.addEvent(rehearsal1);
		band.addEvent(rehearsal2);
		band.addEvent(rehearsal3);

		/*
		 * Test 1
		 * Checking if getSongs returns all currently active songs (but not
		 * those that have been 'deleted')
		 */
		List<Song> expectedResult1 = new ArrayList<Song>(Arrays.asList(
			new Song[]{song1, song3}
		));
		List<Song> result1 = band.getSongs();

		doTest(expectedResult1, result1);

		/*
		 * Test 2
		 * Checking if getSongs returns all songs that were active at a previous
		 * point in time (but have since been 'deleted')
		 */
		List<Song> expectedResult2 = new ArrayList<Song>(Arrays.asList(
			new Song[]{song1, song2}
		));
		List<Song> result2 = band.getSongs(b);

		doTest(expectedResult2, result2);

		/*
		 * Test 3
		 */
		List<Event> expectedResult3 = new ArrayList<Event>(Arrays.asList(
			new Event[]{gig2, gig3, rehearsal2, rehearsal3}
		));

		List<Event> result3 = band.getEvents(b0, c1); 

		doTest(expectedResult3, result3);

		/*
		 * Test 4
		 */
		List<Event> expectedResult4 = new ArrayList<Event>(Arrays.asList(
			new Event[]{gig1, gig2, gig3, rehearsal1, rehearsal2, rehearsal3} 
		));

		List<Event> result4 = band.getEvents();

		doTest(expectedResult4, result4);

		/*
		 * Test 5
		 */
		List<Event> expectedResult5 = new ArrayList<Event>(Arrays.asList(
			new Event[]{gig1, gig2} 
		));

		List<Event> result5 = band.getGigs(a1, b1);

		doTest(expectedResult5, result5);

		/*
		 * Test 6
		 */
		List<Event> expectedResult6 = new ArrayList<Event>(Arrays.asList(
			new Event[]{rehearsal2, rehearsal3} 
		));

		List<Event> result6 = new ArrayList<Event>(band.getRehearsals(a, null)); //rehearsal 2,3

		doTest(expectedResult6, result6);

		/*
		 * Test 7
		 */
		Integer expectedResult7 = 555;
		Integer result7 = band.getBalance(b0, c1);
		doTest(expectedResult7, result7);

		/*
		 * Test 8
		 */
		Integer expectedResult8 = 620;
		Integer result8 = band.getBalanceGigs(a1, b1);
		doTest(expectedResult8, result8);
	}

	private static int i = 0;
	public static void doTest(Object expected, Object result) {
		i++;
		if (expected.equals(result)) {
			System.out.println("Test "+i+" passed");
		}
		else {
			System.out.println("Test "+i+" failed");
		}
	}
}

/**
 * HACK: Ensuring that dates are unique. 
 * This is not a real issue, since songs will not be added and
 * removed within 1 millisecond in 'production'.
 *
 * @author Florian Klampfer
 */
class UniqueDate extends Date {
	public UniqueDate() {
		super();
		try {
			Thread.sleep(1);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
