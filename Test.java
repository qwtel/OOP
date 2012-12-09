/**
 * Test
 * 
 * Handels all TestCases, includes main method.
 * 
 * @author Florian Klampfer, Michael Ion, Johannes Deml
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		Set<Bauernhof> bauernhoefe = new Set<Bauernhof>();
		bauernhoefe.insert(new Bauernhof("OrwellsFarm"));
		bauernhoefe.insert(new Bauernhof("oldMcDonaldsFarm"));
		bauernhoefe.insert(new Bauernhof("FarmVille"));
		
		Geraet g1 = new GeraetDrill(5);
		Traktor tgdr1 = new TraktorBioGas(g1);
		
		Geraet g2 = new GeraetDuenger(2.3f);
		Traktor tgdu1 = new TraktorBioGas(g2);
		
		Geraet g3 = new GeraetDrill(12);
		Traktor tddr1 = new TraktorDiesel(g1);
		
		Geraet g4 = new GeraetDuenger(1.6f);
		Traktor tddu1 = new TraktorDiesel(g2);
		
		Geraet g5 = new GeraetDrill(8);
		Traktor tgdr2 = new TraktorBioGas(g1);
		
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
