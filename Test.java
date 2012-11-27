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

		//Test1
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

		//Test2
		Android hilfskraftUpgrade = new Hilfskraft(0);
		roboShop.insert(hilfskraftUpgrade, hilfskraftSkin, hilfskraftSoftware, hilfskraftAktor);
		
		String result2 = "";
		for(Android a : roboShop) {
			result2 += a.toString();
		}
		String expected2 = hilfskraftUpgrade.toString();
		doTest("Teste Änderung bestehender Androiden", result2, expected2);

		//Test3
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
		
		//Test4
		Android hilfsKraftFailUpgrade = new Hilfskraft(0);
		roboShop.insert(hilfsKraftFailUpgrade, hilfskraftSkin, g2Software, hilfskraftAktor);
		
		String result4 = "";
		for(Android a : roboShop) {
			result4 += a.toString();
		}
		
		String expected4 = expected3;
		doTest("Teste Einfügen von inkompatiblen Androiden", result4, expected4);
		
		//Test5
		Android bauarbeiter_t5 = new Bauarbeiter();
		Skin hochfest_t5 = new SkinHochfest(bauarbeiter_t5.getSeriennummer());
		SoftwareStufe softwareStufe2_t5 = new SoftwareStufe2();
		Software software_t5 = new SoftwareBauarbeiter(bauarbeiter_t5.getSeriennummer(), softwareStufe2_t5);
		Aktor bauarbeiterAktor_t5 = new AktorMax1Kw(hilfskraft.getSeriennummer());
		
		roboShop.insert(bauarbeiter_t5, hochfest_t5, software_t5, bauarbeiterAktor_t5);
		
		String result5 = "";
		for(Android a : roboShop) {
			result5 += a.toString();
		}
		String expected5 = expected3;
		doTest("Testen einer falschen Softwarestufe", result5, expected5);
		
		//Test6
		
		
		
		
		Android bauarbeiter = new Bauarbeiter();
		Android servicetechniker = new Servicetechniker();
		Android transportarbeiter = new Transportarbeiter();
		
		Android leibwaechter = new Leibwaechter();
		Android kaempfer = new Kaempfer();
		Android objektbewacher = new Objektbewacher();

		Skin bauarbeiterSkin = new SkinHochfest(bauarbeiter.getSeriennummer());
		Skin servicetechnikerSkin = new SkinHochfest(servicetechniker.getSeriennummer());
		Skin transportarbeiterSkin = new SkinHochfest(transportarbeiter.getSeriennummer());
		
		Skin leibwaechterSkin = new SkinGepanzert(leibwaechter.getSeriennummer());
		Skin kaempferSkin = new SkinGepanzert(kaempfer.getSeriennummer());
		Skin objektbewacherSkin = new SkinGepanzert(objektbewacher.getSeriennummer());
		
		SoftwareStufe bauarbeiterSoftwareStufe = new SoftwareStufe3();
		SoftwareStufe servicetechnikerSoftwareStufe = new SoftwareStufe3();
		SoftwareStufe transportarbeiterSoftwareStufe = new SoftwareStufe4();
		
		SoftwareStufe objektbewacherSoftwareStufe = new SoftwareStufe4();
		SoftwareStufe leibwaechterSoftwareStufe = new SoftwareStufe4();
		SoftwareStufe kaempferSoftwareStufe = new SoftwareStufe5();
		
		Software bauarbeiterSoftware = new SoftwareBauarbeiter(bauarbeiter.getSeriennummer(), bauarbeiterSoftwareStufe);
		Software servicetechnikerSoftware = new SoftwareServicetechniker(servicetechniker.getSeriennummer(), servicetechnikerSoftwareStufe);
		Software transportarbeiterSoftware = new SoftwareTransportarbeiter(transportarbeiter.getSeriennummer(), transportarbeiterSoftwareStufe);
		
		Software leibwaechterSoftware = new SoftwareLeibwaechter(leibwaechter.getSeriennummer(), leibwaechterSoftwareStufe);
		Software kaempferSoftware = new SoftwareKaempfer(kaempfer.getSeriennummer(), kaempferSoftwareStufe);
		Software objektbewacherSoftware = new SoftwareObjektbewacher(objektbewacher.getSeriennummer(), objektbewacherSoftwareStufe);
		
		Aktor bauarbeiterAktor = new AktorMax5Kw(bauarbeiter.getSeriennummer());
		Aktor servicetechnikerAktor = new AktorMax5Kw(servicetechniker.getSeriennummer());
		Aktor transportarbeiterAktor = new AktorMax10Kw(transportarbeiter.getSeriennummer());
		
		Aktor leibwaechterAktor = new AktorMax10Kw(leibwaechter.getSeriennummer());
		Aktor kaempferAktor = new AktorMaxInfinite(kaempfer.getSeriennummer());
		Aktor objektbewacherAktor = new AktorMax10Kw(objektbewacher.getSeriennummer());
		
		roboShop.insert(bauarbeiter, bauarbeiterSkin, bauarbeiterSoftware, bauarbeiterAktor);
		roboShop.insert(servicetechniker, servicetechnikerSkin, servicetechnikerSoftware, servicetechnikerAktor);
		roboShop.insert(transportarbeiter, transportarbeiterSkin, transportarbeiterSoftware, transportarbeiterAktor);
		
		roboShop.insert(objektbewacher, objektbewacherSkin, objektbewacherSoftware, objektbewacherAktor);
		roboShop.insert(leibwaechter, leibwaechterSkin, leibwaechterSoftware, leibwaechterAktor);
		roboShop.insert(kaempfer, kaempferSkin, kaempferSoftware, kaempferAktor);
		
		String result6 = "";
		for(Android a : roboShop) {
			result6 += a.toString();
		}
		String expected6 = expected3 + bauarbeiter.toString() + servicetechniker.toString() + transportarbeiter.toString() + objektbewacher.toString() + leibwaechter.toString() + kaempfer.toString();
		doTest("Hinzufügen von (zulässigen) Schwerarbeitern und Beschützern ", result6, expected6);
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
