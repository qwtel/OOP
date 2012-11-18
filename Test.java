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
		String test1 = "Testing the size of OrderedSet";
		String test2 = "Testing the order of OrderedSet";

		OrderedSet<Description> set = new OrderedSet<Description>();
		Description desc1 = new Description("asdfasdf");
		Description desc2 = new Description("qwertz");
		Description desc3 = new Description("asdfasdf asdf zzwasdf ad");
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

		doTest(test1, result1, expected1);
		doTest(test2, result2, expected2);

		Description desc4 = new Description("wasd");
 		set.insert(desc4);

		String test3 = "Testing the size of OrderedSet after adding and removing new items";
		int result3 = 0;
		int expected3 = 3;

		String test4 = "Testing the order of OrderedSet after adding and removing new items";
		List<Description> result4 = new ArrayList<Description>();
		List<Description> expected4 = new ArrayList<Description>(Arrays.asList(
			new Description[]{desc4, desc2, /*removed: desc1,*/ desc3}
		));

		it = set.iterator();
		while(it.hasNext()) {
			result3++;

			d = it.next();
			result4.add(d);
		}

		doTest(test3, result3, expected3);
		doTest(test4, result4, expected4);

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
		m1.add(0.6);
		m1.add(0.8); //mean: 0.7
		
		CompositeTime c1 = new CompositeTime(new Double[]{0.3, 0.6, 0.2}); //1.1
		CompositeTime c2 = new CompositeTime(new Double[]{0.1, 0.2, 0.7}); //1.0
		CompositeTime c3 = new CompositeTime(new Double[]{0.2, 0.1, 0.3}); //0.6
		
		Set<CompositeTime> s1 = new Set<CompositeTime>();
		s1.insert(c1);
		s1.insert(c2);
		s1.insert(c3);

		orderedMap.insert(m1, s1);

		MeanElapsedTime m2 = new MeanElapsedTime();
		m2.add(0.1);
		m2.add(0.7); //mean: 0.4
		
		CompositeTime c4 = new CompositeTime(new Double[]{0.2, 0.2, 0.8}); //1.2
		CompositeTime c5 = new CompositeTime(new Double[]{0.0, 0.9, 0.4}); //1.3
		CompositeTime c6 = new CompositeTime(new Double[]{0.9, 0.1, 0.7}); //1.7
		
		Set<CompositeTime> s2 = new Set<CompositeTime>();
		s2.insert(c4);
		s2.insert(c5);
		s2.insert(c6);

		orderedMap.insert(m2, s2);

		String test5 = "Checking iterator in OrderedMap";
		List<MeanElapsedTime> result5 = new ArrayList<MeanElapsedTime>();
		List<MeanElapsedTime> expected5 = new ArrayList<MeanElapsedTime>(
				Arrays.asList(new MeanElapsedTime[] {m2, m1}));

		String test6 = "Checking sub iterator in OrderedMap";
		List<CompositeTime> result6 = new ArrayList<CompositeTime>();
		List<CompositeTime> expected6 = new ArrayList<CompositeTime>(
				Arrays.asList(new CompositeTime[] {c4, c5, c6, c1, c2, c3}));

		String test7 = "Checking getMaxMeasure in MeanElapsedTime (depends on iterator)";
		List<Double> result7 = new ArrayList<Double>();
		List<Double> expected7 = new ArrayList<Double>(
				Arrays.asList(new Double[] {0.7, 0.8})); // because of order (0.4 < 0.7)

		String test8 = "Checking getMinMeasure in CompositeTime (depends on sub iterator)";
		List<Double> result8 = new ArrayList<Double>();
		List<Double> expected8 = new ArrayList<Double>(Arrays.asList(
					new Double[] {0.2, 0.0, 0.1, 0.2, 0.1, 0.1}));

		Iterator<MeanElapsedTime> iter1 = orderedMap.iterator();
		while(iter1.hasNext()) {
			MeanElapsedTime m = iter1.next();
			result5.add(m);
			result7.add(m.getMaxMeasure());

			if(iter1 instanceof Iterable) {
				Iterator iter2 = ((Iterable)iter1).iterator();
				while(iter2.hasNext()) {
					Object o = iter2.next();
					if(o instanceof CompositeTime) {
						CompositeTime c = (CompositeTime)o;
						result6.add(c);
						result8.add(c.getMinMeasure());
					}
				}
			}
		}

		doTest(test5, result5, expected5);
		doTest(test6, result6, expected6);
		doTest(test7, result7, expected7);
		doTest(test8, result8, expected8);

		/*
		 * 3. Falls OrderedMap mit entsprechenden Typparameterersetzungen ein 
		 * Untertyp von OrderedSet ist, betrachten Sie die in Punkt 2 erzeugte 
		 * Menge als Instanz von OrderedSet, fügen Sie noch einige Elemente ein, 
		 * lesen Sie alle Elemente über den Iterator aus, und schreiben Sie die 
		 * größten Messwerte in die Standard-Ausgabe. 
		 * Falls OrderedMap kein Untertyp von OrderedSet ist, geben Sie anstelle
		 * der Testergebnisse eine Begründung dafür aus, warum zwischen diesen 
		 * Typen keine Untertypbeziehung besteht.
		 */
		String test9 = "Is OrderedSet really a sub type of OrderedMap?";

		OrderedSet<MeanElapsedTime> orderdSet = 
			(OrderedSet<MeanElapsedTime>)orderedMap;

		MeanElapsedTime m3 = new MeanElapsedTime();
		m3.add(0.6);
		m3.add(0.4); // mean: 0.5
		orderdSet.insert(m3);

		MeanElapsedTime m4 = new MeanElapsedTime();
		m4.add(0.5);
		m4.add(0.1); // mean: 0.3
		orderdSet.insert(m4);

		List<Double> result9 = new ArrayList<Double>();
		List<Double> expected9 = new ArrayList<Double>(
				Arrays.asList(new Double[] {0.5, 0.7, 0.6, 0.8})); // because of order

		for(MeanElapsedTime m : orderdSet) {
			result9.add(m.getMaxMeasure());
		}

		doTest(test9, result9, expected9);

		/*
		 * 4. Erzeugen Sie eine Instanz von OrderedSet, deren Elemente vom Typ 
		 * ElapsedTime sind. Lesen Sie alle Elemente der in Punkt 2 erzeugten 
		 * (und möglicherweise in Punkt 3 erweiterten) Menge und alle Objekte, 
		 * auf welche die Elemente verweisen, aus und fügen Sie diese 
		 * (Instanzen von MeanElapsedTime ebenso wie von CompositeTime) in die 
		 * neue Menge ein. Lesen Sie alle Elemente der neuen Menge aus, und 
		 * schreiben Sie die durch count ermittelten Werte in die 
		 * Standard-Ausgabe.
		 */
		OrderedSet<ElapsedTime> ALL_THE_THINGS = new OrderedSet<ElapsedTime>();

		iter1 = orderedMap.iterator();
		while(iter1.hasNext()) {
			MeanElapsedTime m = iter1.next();
			ALL_THE_THINGS.insert(m);

			if(iter1 instanceof Iterable) {
				Iterator iter2 = ((Iterable)iter1).iterator();
				while(iter2.hasNext()) {
					Object o = iter2.next();
					if(o instanceof CompositeTime) {
						CompositeTime c = (CompositeTime)o;
						ALL_THE_THINGS.insert(c);
					}
				}
			}
		}

		String test10 = "Checking if all the things are in the set";
		List<Integer> result10 = new ArrayList<Integer>();
		List<Integer> expected10 = new ArrayList<Integer>(
				Arrays.asList(new Integer[] {2, 2, 2, 3, 2, 3, 3, 3, 3, 3}));

		for(ElapsedTime e : ALL_THE_THINGS) {
			result10.add(e.count());
		}

		doTest(test10, result10, expected10);
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
