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
		int height = 5;
		int width = 5;
		Grid grid1 = new Grid(width, height);
		Strategy s1 = new LineStrategy();
		Strategy s2 = new RandomStrategy();
		Car[] carArray = new Car[10];

		carArray[0] = new FastCar("S. Vettel", grid1, s1, 15, 0, 0, 3);
		carArray[1] = new FastCar("R. Gosling", grid1, s1, 35, 3, 2, 1);
		carArray[2] = new FastCar("Knight Rider", grid1, s1, 30, 4, 3, 0);
		carArray[3] = new FastCar("Brian O'Conner", grid1, s1, 25, 2, 2, 2);
		carArray[4] = new FastCar("Lightning McQueen", grid1, s1, 20, 0, 2, 3);
		carArray[5] = new FlexCar("Transporter", grid1, s1, 50, 3, 0, 0);
		carArray[6] = new FlexCar("Ricco", grid1, s1, 55, 4, 1, 2);
		carArray[7] = new FlexCar("Mad Max", grid1, s1, 40, 0, 2, 1);
		carArray[8] = new FlexCar("David Mann", grid1, s1, 45, 3, 4, 1);
		carArray[9] = new FlexCar("Hot Rod", grid1, s1, 10, 4, 4, 3);
		
		for(Car a: carArray) {
			a.start();
		}
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
