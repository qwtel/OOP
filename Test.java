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
		
		//Test4
		//TODO: Nach dem Fehler in DarkBox suchen
		description = "Tests the features of scaling and chnging the " +
					  "char it is filled with";
		ClassicBox cb = new DarkBox(2.3, 1.8, 'c');
		cb.setFill('>');
		cb.scale(3);
		pict = cb;
		expected = ">>>>>>>>>\n" +
				   ">>>>>>>>>\n" +
				   ">>>>>>>>>\n" +
				   ">>>>>>>>>\n" +
				   ">>>>>>>>>\n" +
				   ">>>>>>>>>\n";
		doTest(description, pict.toString(), expected);
		
		//Test5
		description = "Tests the scaling fuction of DarkBox";
		pict = new DarkBox(5.0,1.2,'x');
		pict.scale(0.5);
		expected = "xxx\n";
		doTest(description, pict.toString(), expected); 
		
		//Test6
		description = "Tests the ratio fuction of ClearBox ";
		ClearBox clearBox = new ClearBox(64.26, 1.53);
		double expectedDouble = 42;
		doTest(description, clearBox.getRatio(), expectedDouble);
		
		//Test7
		description = "Tests the scaling function of ClearBox";
		pict = new ClearBox(2.3, 4.5);
		pict.scale(1.4);
		expected = "****\n" +
				   "*  *\n" +
				   "*  *\n" +
				   "*  *\n" +
				   "*  *\n" +
				   "*  *\n" +
				   "****\n";
		doTest(description, pict.toString(), expected);
	
		//Test8
		description = "Tests the scaling and toString functionality of Scaled";
		Pict[][] array = new Pict[2][3];
		array[0][0] = new Box(3.7,3.3,'o','.');
		array[0][1] = new DarkBox(2.3, 1.8, 'c');
		array[0][2] = new ClearBox(7.3, 4.5);
		array[1][0] = new DarkBox(2.3, 1.8, 'c');
		array[1][1] = new ClearBox(2.3, 4.5);
		array[1][2] = new Box(3.7,5.3,'o','.');
		pict = new Scaled<Pict>(array);
		pict.scale(0.7);
		expected = 	"ooo   cc \n" +
					"o.o   cc \n" +
					"ooo      \n" +
					"cc    ** \n" +
					"cc    ** \n" +
					"      ** \n" +
					"      ** \n" +
					"******ooo\n" +
					"*    *o.o\n" +
					"*    *o.o\n" +
					"******ooo";

		doTest(description, pict.toString(), expected);
		
		//Test9
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
