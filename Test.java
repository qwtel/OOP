/**
 * Test
 * 
 * Handels all TestCases, includes main method.
 * 
 * @author Florian Klampfer, Michael Ion, Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {
		
		//Test1
		private Grid grid1 = new Grid();
		private Strategy s1 = new Strategy();
		private Strategy s2 = new Strategy();
		
		Car c1 = new FastCar("S. Vettel", grid1, s1);
		Car c2 = new FastCar("R. Gosling", grid1, s1);
		Car c3 = new FastCar("Knight Rider", grid1, s1);
		Car c4 = new FastCar("Brian O'Conner", grid1, s1);
		Car c5 = new FastCar("Lightning McQueen", grid1, s1);
		Car c6 = new FlexCar("Transporter", grid1, s1);
		Car c7 = new FlexCar("Ricco", grid1, s1);
		Car c8 = new FlexCar("Mad Max", grid1, s1);
		Car c9 = new FlexCar("David Mann", grid1, s1);
		Car c10 = new FlexCar("Hot Rod", grid1, s1);
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
