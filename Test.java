/**
 * Handels all TestCases, includes main method.
 */
public class Test {
	
	public static void main(String[] args) throws Exception {


	}

	private static int i = 0;

	/**
	 * @param description Informationen ueber den Testversuch.
	 * @param result Die berechnete Loesung fuer den Test.
	 * @param expected Die erwartete Loesung fuer den Test.
	 */
	private static void doTest(String description, Object result, 
			Object expected) {

		i++;
		System.out.println("Test "+i+" "+description);

		if (expected.equals(result)) {
			System.out.println("Result: " + result);
			System.out.println("Passed");
		}
		else {
			System.out.println("\nExpected result");
			System.out.println(expected);

			System.out.println("Failed Result");
			System.out.println(result);

			System.out.println("Test "+i+" failed!");
		}

		System.out.println(
				"------------------------------------------------------");
	}
}
