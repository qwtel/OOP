/**
 * Test
 * 
 * Handels all TestCases, includes main method.
 * 
 * @author Florian Klampfer, Michael Ion, Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {
		
		// Test1
		int height = 5;
		int width = 5;

		Grid grid1 = new Grid(width, height);

		grid1.addCar(new FastCar("S. Vettel", grid1, new RandomStrategy(grid1), 15, 0, 0, 2));
		grid1.addCar(new FastCar("R. Gosling", grid1, new RandomStrategy(grid1), 35, 3, 2, 1));
		grid1.addCar(new FastCar("Knight Rider", grid1, new RandomStrategy(grid1), 30, 4, 3, 0));
		grid1.addCar(new FastCar("Brian O'Conner", grid1, new SerpentStrategy(grid1), 25, 2, 2, 2));
		grid1.addCar(new FastCar("Hot Rod", grid1, new SerpentStrategy(grid1), 20, 0, 2, 1));
		grid1.addCar(new FlexCar("Transporter", grid1, new CircleStrategy(grid1), 50, 3, 0, 0));
		grid1.addCar(new FlexCar("Lightning McQueen", grid1, new CircleStrategy(grid1), 10, 4, 4, 3));
		grid1.addCar(new FlexCar("Ricco", grid1, new RandomStrategy(grid1), 55, 4, 1, 2));
		grid1.addCar(new FlexCar("Mad Max", grid1, new RandomStrategy(grid1), 40, 0, 2, 1));
		grid1.addCar(new FlexCar("David Mann", grid1, new RandomStrategy(grid1), 45, 3, 4, 1));

		grid1.startGame();
		System.out.println(grid1.toString());

		// Test 2
		/*
		 * Tests the System under extreme conditions. All cars are placed in a 3x3 field and
		 * use a random strategy
		 */
		
		width = 20;
		height = 20;
		
		Grid grid2 = new Grid(width, height);
		
		grid2.addCar(new FastCar("S. Vettel",grid2, new RandomStrategy(grid2),0,9,9,1));
		grid2.addCar(new FastCar("R. Gosling",grid2, new RandomStrategy(grid2),0,9,10,1));
		grid2.addCar(new FastCar("Knight Rider",grid2, new RandomStrategy(grid2),0,9,11,0));
		grid2.addCar(new FastCar("Brian O'Conner",grid2, new RandomStrategy(grid2),0,10,11,0));
		grid2.addCar(new FastCar("Hot Rod",grid2, new RandomStrategy(grid2),0,11,11,3));
		grid2.addCar(new FlexCar("Transporter",grid2, new RandomStrategy(grid2),0,11,10,3));
		grid2.addCar(new FlexCar("Lightning McQueen",grid2, new RandomStrategy(grid2),0,11,9,2));
		grid2.addCar(new FlexCar("Ricco",grid2, new RandomStrategy(grid2),0,10,9,2));
		grid2.addCar(new FlexCar("Mad Max",grid2, new RandomStrategy(grid2),0,10,10,0));
		grid2.addCar(new FlexCar("David Mann",grid2, new RandomStrategy(grid2),0,10,10,2));
		
		grid2.startGame();
		System.out.println(grid2.toString());
		
		// Test 3
		/*
		 * All cars are placed in the left upper corner and look in the same direction
		 */
		width = 10;
		height =10;
		
		Grid grid3 = new Grid(width,height);
		
		grid3.addCar(new FastCar("S. Vettel",grid3,new RandomStrategy(grid3),0,0,0,1));
		grid3.addCar(new FastCar("R. Gosling",grid3,new SerpentStrategy(grid3),0,0,0,1));
		grid3.addCar(new FastCar("Knight Rider",grid3,new CircleStrategy(grid3),0,0,0,1));
		grid3.addCar(new FastCar("Brian O'Conner",grid3,new RandomStrategy(grid3),0,0,0,1));
		grid3.addCar(new FastCar("Hot Rod",grid3,new RandomStrategy(grid3),0,0,0,1));
		
		grid3.addCar(new FlexCar("Transporter",grid3,new RandomStrategy(grid3),0,0,0,1));
		grid3.addCar(new FlexCar("Lightning McQueen",grid3,new SerpentStrategy(grid3),0,0,0,1));
		grid3.addCar(new FlexCar("Ricco",grid3,new CircleStrategy(grid3),0,0,0,1));
		grid3.addCar(new FlexCar("Mad Max",grid3,new RandomStrategy(grid3),0,0,0,1));
		grid3.addCar(new FlexCar("David Mann",grid3,new RandomStrategy(grid3),0,0,0,1));
		
		grid3.startGame();
		System.out.println(grid3.toString());
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
