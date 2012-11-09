/**
 * Test
 * 
 * handels all TestCases, includes main method
 * 
 * @author Florian Klampfer, Michael Ion Johannes Deml
 * @version 1.4
 */
public class Test {
	public static void main(String[] args) {
		System.out.println("Tests für die Typen Box, ClearBox, DarkBox und FreeBox\n");
				
		/**
		 * Test1
		 * tests the scaling function of Box
		 */
		Box box1 = new Box(3.7,2.3,'o','.');
		box1.scale(2);
		Box expectedBox1 = new Box(3.7*2,2.3*2,'o','.');
		doTest(box1,expectedBox1);
		System.out.println("Result:");
		System.out.println(box1.toString());
		
		
		
		System.out.println("\n------------------------------------------------------" +
						   "\nTests für die Typen Repeated<P> und Scaled<P>\n");

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
