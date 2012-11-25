/**
 * Test
 * 
 * Handels all TestCases, includes main method.
 * 
 * @author Florian Klampfer, Michael Ion, Johannes Deml
 */
public class Test {
	public static void main(String[] args) throws Exception {
		RobiesRoboShop roboShop = new RobiesRoboShop();

		Android hilfskraft = new Hilfskraft();

		Skin hilfskraftSkin = new SkinBeruehrungssenstiv(
				hilfskraft.getSeriennummer());

		SoftwareStufe stufe1 = new SoftwareStufe1();
		Software hilfskraftSoftware = new SoftwareHilfskraft(
				hilfskraft.getSeriennummer(), stufe1);

		hilfskraft.setSkin(hilfskraftSkin);
		hilfskraft.setSoftware(hilfskraftSoftware);

		roboShop.insert(hilfskraft);
		String result1 = roboShop.find(hilfskraft.getSeriennummer());
		String expected1 = hilfskraft.toString();
		doTest("asdf", result1, expected1);

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
