/**
 * Test
 * 
 * handels all TestCases, includes main method
 * 
 * @author Florian Klampfer, Michael Ion Johannes Deml
 * @version 1.4
 */
public class Test {
	public static void main(String[] args) throws Exception {
        String description = "Testing the scaling function of Box.";
		Box box1 = new Box(3.7,2.3,'o','.');
		box1.scale(2);
		Box expectedBox1 = new Box(3.7*2,2.3*2,'o','.');
		doTest(description, box1, expectedBox1);
	}

	private static int i = 0;
	public static void doTest(String description, Object expected, 
            Object result) {

		i++;
		System.out.println("Test "+i+" "+description);

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
