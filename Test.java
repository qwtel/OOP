/**
 * Test
 * 
 * handels all TestCases, includes main method
 * 
 * @author Florian Klampfer, Michael Ion Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {
		//Test1
		String description = "Testing the scaling function of Box.";
		Pict pict = new Box(3.7,2.3,'o','.');
		pict.scale(2);
		Pict expectedPict = new Box(3.7*2, 2.3*2, 'o', '.');
		doTest(description, pict, expectedPict);
		
		//Test2
		description = "Tests the scaling function of FreeBox";
		pict = new FreeBox("01234\n56789");
		pict.scale(2);
		doTest(description, pict.toString(),  "0123401234\n5678956789\n" +
				"0123401234\n5678956789\n");
	}

	private static int i = 0;
	public static void doTest(String description, Object result, 
			Object expected) {

		i++;
		System.out.println("Test "+i+": "+description);

		if (expected.equals(result)) {
			System.out.println("Result:");
			System.out.println(result);
			System.out.println("Test "+i+" passed.");
		}
		else {
			System.out.println("Expected result:");
			System.out.println(expected);

			System.out.println("Failed Result:");
			System.out.println(result);

			System.out.println("Test "+i+" failed!");
		}

		System.out.println(
				"------------------------------------------------------\n");

	}
}
