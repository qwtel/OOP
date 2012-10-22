import java.util.*;

/**
 * Quick and dirty test class
 * @author Johannes Deml, Michael Ion, Florian Klampfer 
 */
public class Test {
	public static void main(String[] args){
		Date a1 = new UniqueDate();
		Date a = new UniqueDate();

		Musician musician1 = new Musician("Though Guy", "555123", "Bass");
		Musician musician2 = new Musician("Sweet Guy", "555456", "Piano"); 
		Musician musician3 = new Musician("Guy with Glasses", "555789", "Guitar");  

		Song song1 = new Song("Energy Wizard", 225);
		Song song2 = new Song("Brain Damage", 230);
		Song song3 = new Song("Contrapunctus 11", 350);

		Gig gig1 = new Gig("Volksoper", a, 3500, 120);
		Gig gig1change = new Gig("Stadttheater", a, 3500, 120);
		Rehearsal rehearsal1 = new Rehearsal("Mamas Keller", a, 1750, 50);

		Band band = new Band("A Drop In The Sea");

		band.addMusician(musician1);

		/*
		 * Only musician2 can play this song. It should never be returned by
		 * getSongs
		 */
		Song song4 = new Song("Nobody wants to play this song", 350);
		musician2.addSong(song4);
		band.addMusician(musician2);

		band.addSong(song1);
		band.addEvent(gig1);
		UniqueDate.sleep(); // for side effects

		band.addSong(song2);
		Date b0 = new UniqueDate();
		Date b = new UniqueDate();
		Date b1 = new UniqueDate();
		Gig gig2 = new Gig("Seitengasse", b, 5000, 500);
		Rehearsal rehearsal2 = new Rehearsal("Dorftheater", b, 2500, 20);

		band.addSong(song3);
		UniqueDate.sleep();

		band.removeSong(song2);
		UniqueDate.sleep(); 

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
		Set<Song> expectedResult1 = new HashSet<Song>(Arrays.asList(
			new Song[]{song1, song3}
		));
		Set<Song> result1 = band.getSongs();
		System.out.println(result1);

		doTest(expectedResult1, result1);

		/*
		 * Test 2
		 * Checking if getSongs returns all songs that were active at a previous
		 * point in time (but have since been 'deleted')
		 */
		Set<Song> expectedResult2 = new HashSet<Song>(Arrays.asList(
			new Song[]{song1, song2}
		));
		Set<Song> result2 = band.getSongs(b);

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
		
        /*
         * Aufgabe 2
         *
		 * Test 9
		 * 
		 * Checks changeHist functionality in Event
		 */
		
		List<Event> expectedResult9 = new ArrayList<Event>(Arrays.asList(
				new Event[]{gig1})); 
		gig1.setLocation("Stadttheater");
		doTest(expectedResult9, gig1.getChangeHist());
		
		
		/*
		 * Test 10
		 * 
		 * Checks functionality of deletedEvents list
		 */
		List<Event> expectedResult10 = new ArrayList<Event>(Arrays.asList(
				new Event[]{gig1}));
		band.removeEvent(gig1);
		doTest(expectedResult10, band.getDeletedEvents());

		/*
		 * Managing multiple bands
		 */
		BandManager manager = new BandManager();
		manager.addBand(band);
		
		Band band2 = new Band("The Swift Taylors");
		manager.addBand(band2);

		Musician musician4 = new Musician("Wierd Guy", "555asdf", "Bass");
		band2.addMusician(musician4);

		// This guy plays in both bands. 
		band2.addMusician(musician1);

		Song song5 = new Song("Intro", 15);
		band2.addSong(song5);

		Song song6 = new Song("Outro", 29);
		band2.addSong(song6);

		/*
		 * Add a guy to band1. Since he in not primary, he should not affect
		 * that band1 is able to play song1 and song2.
		 */
		band.addMusician(musician3, false);

		/*
		 * Test 11
		 * This should return the intro and outro as well as all songs of band1.
		 * (song1 and song3) See Test1.
		 */
		Set<Song> expectedResult11 = new HashSet<Song>(Arrays.asList(
				new Song[]{song5, song6, song1, song3}
		));

		Set<Song> result11 = manager.getSongs();
		doTest(expectedResult11, result11);

		/*
		 * Test 12
		 * Now we mark musician3 as primary. This means that band1 is no longer 
		 * albe play song1 and song2 since not all primary members have 
		 * them in their repository.
		 */
		band.markPrimary(musician3);

		Set<Song> expectedResult12 = new HashSet<Song>(Arrays.asList(
				new Song[]{song5, song6}
		));

		Set<Song> result12 = manager.getSongs();
		doTest(expectedResult12, result12);

		/*
		 * Test 13
		 */
		Set<Musician> expectedResult13 = new HashSet<Musician>(Arrays.asList(
				new Musician[]{}
        ));
		expectedResult13.addAll(band.getMusicians());

		Set<Musician> result13 = manager.getMusicians();
		doTest(expectedResult13, result13);

        System.out.println("For additional information see Test.java");
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
 * XXX: Ensuring that dates are unique. 
 * This is not a real issue, since songs will not be added and
 * removed within 1 millisecond in 'production'.
 *
 * @author Florian Klampfer
 */
class UniqueDate extends Date {
	private static final long serialVersionUID = 1L;

	public UniqueDate() {
		super();
		sleep();
	}

	public static void sleep() {
		try {
			Thread.sleep(1);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
