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

		Strategy s1 = new LineStrategy(grid1);
		Strategy s2 = new RandomStrategy(grid1);

		grid1.addCar(new FastCar("S. Vettel", grid1, new RandomStrategy(grid1), 15, 0, 0, 2));
		grid1.addCar(new FastCar("R. Gosling", grid1, new RandomStrategy(grid1), 35, 3, 2, 1));
		grid1.addCar(new FastCar("Knight Rider", grid1, new RandomStrategy(grid1), 30, 4, 3, 0));
		grid1.addCar(new FastCar("Brian O'Conner", grid1, new RandomStrategy(grid1), 25, 2, 2, 2));
		grid1.addCar(new FastCar("Hot Rod", grid1, new RandomStrategy(grid1), 20, 0, 2, 1));
		grid1.addCar(new FlexCar("Transporter", grid1, new RandomStrategy(grid1), 50, 3, 0, 0));
		grid1.addCar(new FlexCar("Lightning McQueen", grid1, new RandomStrategy(grid1), 10, 4, 4, 3));
		grid1.addCar(new FlexCar("Ricco", grid1, new RandomStrategy(grid1), 55, 4, 1, 2));
		grid1.addCar(new FlexCar("Mad Max", grid1, new RandomStrategy(grid1), 40, 0, 2, 1));
		grid1.addCar(new FlexCar("David Mann", grid1, new RandomStrategy(grid1), 45, 3, 4, 1));

		grid1.startGame();
		System.out.println(grid1.toString());

		// TODO Test 2
		// TODO Test 3
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
