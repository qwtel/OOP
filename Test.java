import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Test
 * 
 * Handels all TestCases, includes main method.
 * 
 * @author Florian Klampfer, Michael Ion, Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {
		/*
		 * 1. Erzeugen Sie eine Instanz von OrderedSet deren Elemente vom Typ 
		 * Description sind. Fügen Sie einige Elemente in unsortierter 
		 * Reihenfolge ein, lesen Sie alle Elemente der Menge über den Iterator 
		 * aus, und schreiben Sie die Anzahlen der Zeilen in die Standard-
		 * Ausgabe. 
		 * Führen Sie Änderungen durch und geben Sie die Elemente erneut aus. 
		 * Diesen Vorgang können Sie mit unterschiedlichen Änderungen so oft 
		 * wiederholen, wie es Ihnen als nötig erscheint.
		 */
		OrderedSet<Description> set = new OrderedSet<Description>();
		Description desc1 = new Description("asdfasdf");
		Description desc2 = new Description("qwertz");
		Description desc3 = new Description("asdf asdf asdf zzwasdf ad");
		set.insert(desc1);
		set.insert(desc2);
		set.insert(desc3);
		
		int result1 = 0;
		int expected1 = 3;

		List<Description> result2 = new ArrayList<Description>();
		List<Description> expected2 = new ArrayList<Description>(Arrays.asList(
			new Description[]{desc2, desc1, desc3}
		));
		
		Iterator<Description> it = set.iterator();
		Description d;
		while(it.hasNext()) {
			result1++;

			d = it.next();
			result2.add(d);

			// preparation for the next test
			if(d == desc1) {
				it.remove();
			}
		}

		doTest("Testing the size of OrderedSet", result1, expected1);
		doTest("Testing the order of OrderedSet", result2, expected2);

		Description desc4 = new Description("wasd");
 		set.insert(desc4);

		int result3 = 0;
		int expected3 = 3;

		List<Description> result4 = new ArrayList<Description>();
		List<Description> expected4 = new ArrayList<Description>(Arrays.asList(
			new Description[]{desc4, desc2, /*desc1,*/ desc3}
		));

		it = set.iterator();
		while(it.hasNext()) {
			result3++;

			d = it.next();
			result4.add(d);
		}

		doTest("Testing the size of OrderedSet after adding and removing new " +
				"items", result3, expected3);
		doTest("Testing the order of OrderedSet after adding and removing new" +
				" items", result4, expected4);

		/*
		 * 2. Erzeugen Sie eine Instanz von OrderedMap, deren Elemente vom Typ 
		 * MeanElapsedTime sind und die auf Objekte vom Typ CompositeTime 
		 * verweisen – nicht sehr sinnvoll, aber gut zum Testen geeignet. 
		 * Fügen Sie einige Elemente und damit verbundene Objekte ein, lesen Sie 
		 * alles über die Iteratoren aus, und schreiben Sie jeweils den größten 
		 * Messwert (für Elemente) bzw. die kürzeste Einzelzeit (für Objekte, 
		 * auf die Elemente verweisen) in die Standard-Ausgabe. 
		 * Testen Sie Änderungen ähnlich wie bei Punkt 1.
		 */
		OrderedMap<MeanElapsedTime, CompositeTime> orderedMap = 
			new OrderedMap<MeanElapsedTime, CompositeTime>();

		MeanElapsedTime m1 = new MeanElapsedTime();
		m1.add(0.1);
		MeanElapsedTime m2 = new MeanElapsedTime();
		m2.add(0.15);
		m2.add(0.355);
		MeanElapsedTime m3 = new MeanElapsedTime();
		m3.add(0.0123);
		m3.add(0.0927);
		m3.add(0.9296);

		CompositeTime c1 = new CompositeTime(new double[]{0.3, 0.6, 0.123});
		CompositeTime c2 = new CompositeTime(new double[]{0.13, 0.02234, 0.17236});
		CompositeTime c3 = new CompositeTime(new double[]{0.012, 0.169, 0.32534});

		// XXX: What is this shit???
	}

	private static int i = 0;
	public static void doTest(String description, Object result, 
			Object expected) {

		i++;
		System.out.println("Test "+i+": "+description);

		if (expected.equals(result)) {
			System.out.println("\nResult:");
			System.out.println(result);
			System.out.println("Test "+i+" passed.");
		}
		else {
			System.out.println("\nExpected result:");
			System.out.println(expected);

			System.out.println("Failed Result:");
			System.out.println(result);

			System.out.println("Test "+i+" failed!");
		}

		System.out.println(
				"------------------------------------------------------\n");

	}
}
