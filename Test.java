/**
 * Handels all TestCases, includes main method.
 */
public class Test {
	
	public static void main(String[] args) throws Exception {
		Baeckerei baeckerei = new Baeckerei();
		Bestellung bestellung = new Bestellung();

		bestellung.add(Form.Rund, 10, Teigart.Muerb);
		bestellung.add(Form.Rund, 10, Teigart.Zimtstern);
		bestellung.add(Form.Rund, 10, Teigart.Schoko);
		bestellung.add(Form.Mond, 10, Teigart.Muerb);
		bestellung.add(Form.Mond, 10, Teigart.Zimtstern);
		bestellung.add(Form.Mond, 10, Teigart.Schoko);
		bestellung.add(Form.Weihnachtsmann, 10, Teigart.Muerb);
		bestellung.add(Form.Weihnachtsmann, 10, Teigart.Zimtstern);
		bestellung.add(Form.Weihnachtsmann, 10, Teigart.Schoko);
		bestellung.drucke();

		Keksdose dose = baeckerei.nimmBestllungAuf(bestellung);
		dose.inhalt();

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
