/**
 * Test
 * 
 * handels all TestCases, includes main method
 * 
 * @author Florian Klampfer, Michael Ion Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {

        /*
         * Box - ClearBox: Keine Untertypbeziehung, da Clearbox das Leerzeichen
         * für den Rand verwendet, aber Box genau das nicht erlaubt.
         *
         * Box - DarkBox: Keine Untertypbeziehung, da DarkBox nachträgliches
         * ändern der Füllung zulässt, aber Box genau das nicht erlaubt.
         *
         * Box - FreeBox: Keine Untertypbeziehung, da FreeBox keinen Rand 
         * besitzt (In unserem Fall: FreeBox ist keine ClassicBox)
         *
         * ClearBox - DarkBox: Keine Untertypbeziehung, da DarkBox das ändern
         * der Füllung zulässt.
         *
         * ClearBox - FreeBox: Kein Untertypbeziehung, da FreeBox keinen Rand
         * besitzt.
         *
         * DarkBox - FreeBox: Keine Untertypbeziehung, da FreeBox keinen Rand
         * besitzt.
         */

        String description;
        Pict pict;
        String expected;

		//Test1
		description = "Testing the scaling function of Box.";
		pict = new Box(3.7,2.3,'o','.');
		pict.scale(2);
		expected = "oooooooo\n"+
                          "o......o\n"+
                          "o......o\n"+
                          "o......o\n"+
                          "oooooooo\n";
		doTest(description, pict.toString(), expected);
		
		//Test2
		description = "Tests the scaling function of FreeBox when > 1";
		pict = new FreeBox("01234\n"+
                           "56789\n");
		pict.scale(2);
        expected = "0123401234\n" +
                   "5678956789\n" +
				   "0123401234\n" + 
                   "5678956789\n";
		doTest(description, pict.toString(), expected);

		//Test3
		description = "Tests the scaling function of FreeBox when < 1";
		pict = new FreeBox("01234\n"+
                           "56789\n");
		pict.scale(0.5);
        expected = "012\n";
		doTest(description, pict.toString(), expected);
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
