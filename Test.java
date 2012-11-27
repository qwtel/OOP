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
		Aktor hilfskraftAktor = new AktorMax1Kw(hilfskraft.getSeriennummer());

		roboShop.insert(hilfskraft, hilfskraftSkin, hilfskraftSoftware, hilfskraftAktor);

		String result1 = roboShop.find(hilfskraft.getSeriennummer());
		String expected1 = hilfskraft.toString();
		doTest("Test Einfügen von Androiden", result1, expected1);

		Android hilfskraftUpgrade = new Hilfskraft(0);
		roboShop.insert(hilfskraftUpgrade, hilfskraftSkin, hilfskraftSoftware, hilfskraftAktor);
		
		String result2 = "";
		for(Android a : roboShop) {
			result2 += a.toString();
		}
		String expected2 = hilfskraftUpgrade.toString();
		doTest("Teste Änderung bestehender Androiden", result2, expected2);

		Android g1 = new Gesellschafter();
		Android g2 = new Gesellschafter();
		Android g3 = new Gesellschafter();

		Skin g2Skin = new SkinBeruehrungssenstiv(g2.getSeriennummer());
		SoftwareStufe g2Stufe1 = new SoftwareStufe1();
		Software g2Software = new SoftwareGesellschafter(g2.getSeriennummer(), 
				g2Stufe1);
		Aktor g2Aktor = new AktorMax1Kw(g2.getSeriennummer());

		roboShop.insert(g2, g2Skin, g2Software, g2Aktor);

		String result3 = "";
		for(Android a : roboShop) {
			result3 += a.toString();
		}

		String expected3 = hilfskraftUpgrade.toString() + g2.toString();
		doTest("Teste iterator", result3, expected3);
		
		Android hilfsKraftFailUpgrade = new Hilfskraft(0);
		roboShop.insert(hilfsKraftFailUpgrade, hilfskraftSkin, g2Software, hilfskraftAktor);
		
		String result4 = "";
		for(Android a : roboShop) {
			result4 += a.toString();
		}
		
		String expected4 = expected3;
		doTest("Teste einfügen von inkompatiblen Androiden", result4, expected4);
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
