import java.lang.reflect.Method;

 /**
  * Test
  * 
  * Handels all TestCases, includes main method.
  * 
  * @author Florian Klampfer, Michael Ion, Johannes Deml
  */

@ClassAuthor(who="Florian Klampfer, Johannes Deml, Michael Ion")
public class Test {
	@MethodAuthor(who="Florian Klampfer, Johannes Deml, Michael Ion")
	public static void main(String[] args) throws Exception {
		
		Set<Bauernhof> bauernhoefe = new Set<Bauernhof>();
		Bauernhof b1 = new Bauernhof("OrwellsFarm"); // XXX
		bauernhoefe.insert(b1);
		bauernhoefe.insert(new Bauernhof("oldMcDonaldsFarm"));
		bauernhoefe.insert(new Bauernhof("FarmVille"));
		
		Geraet g1 = new GeraetDrill(5);
		Traktor t1 = new TraktorBioGas(g1);
		t1.erhoeheStunden(3);
		
		Geraet g2 = new GeraetDuenger(2.3f);
		Traktor t2 = new TraktorBioGas(g2);
		t2.erhoeheStunden(3);
		
		Geraet g3 = new GeraetDrill(12);
		Traktor t3 = new TraktorDiesel(g3);
		t3.erhoeheStunden(3);
		
		Geraet g4 = new GeraetDuenger(1.6f);
		Traktor t4 = new TraktorDiesel(g4);
		t4.erhoeheStunden(3);
		
		Geraet g5 = new GeraetDrill(8);
		Traktor t5 = new TraktorBioGas(g5);
		t5.erhoeheStunden(3);

		// XXX
		b1.addTraktor(t1);
		b1.addTraktor(t2);
		b1.addTraktor(t3);
		b1.addTraktor(t4);
		b1.addTraktor(t5);

		System.out.println(getClassAnnotation(Bauernhof.class));
		System.out.println(getClassAnnotation(ClassAuthor.class));
		System.out.println(getClassAnnotation(Geraet.class));
		System.out.println(getClassAnnotation(GeraetDrill.class));
		System.out.println(getClassAnnotation(GeraetDuenger.class));
		System.out.println(getClassAnnotation(MethodAuthor.class));
		System.out.println(getClassAnnotation(Set.class));
		System.out.println(getClassAnnotation(Test.class));
		System.out.println(getClassAnnotation(Traktor.class));
		System.out.println(getClassAnnotation(TraktorBioGas.class));
		System.out.println(getClassAnnotation(TraktorDiesel.class));

		doTest("avgBetriebszeit", b1.avgBetriebszeit(), 3);
		doTest("avgBetriebszeitDiesel", b1.avgBetriebszeitDiesel(), 3);
		doTest("avgBetriebszeitBiogas", b1.avgBetriebszeitBiogas(), 3);
		doTest("avgBetriebszeitDuengen", b1.avgBetriebszeitDuengen(), 3);
		doTest("avgBetriebszeitSaeen", b1.avgBetriebszeitSaeen(), 3);

		doTest("maxSaescharen", b1.maxSaescharen(), 12);
		doTest("maxSaescharenBiogas", b1.maxSaescharenBiogas(), 8);
		doTest("maxSaescharenDiesel", b1.maxSaescharenDiesel(), 12);
			
		doTest("minSaescharen", b1.minSaescharen(), 5);
		doTest("minSaescharenBiogas", b1.minSaescharenBiogas(), 5);
		doTest("minSaescharenDiesel", b1.minSaescharenDiesel(), 12);
		
		doTest("maxKapazitaet", b1.maxKapazitaet(), 2.3f);
		doTest("maxKapazitaetBiogas", b1.maxKapazitaetBiogas(), 2.3f);
		doTest("maxKapazitaetDiesel", b1.maxKapazitaetDiesel(), 1.6f);
		
		doTest("minKapazitaet", b1.minKapazitaet(), 1.6f);
		doTest("minKapazitaetBiogas", b1.minKapazitaetBiogas(), 2.3f);
		doTest("minKapazitaetDiesel", b1.minKapazitaetDiesel(), 1.6f);
	}

	@MethodAuthor(who="Johannes Deml")
	private static String getClassAnnotation(Class c){
		String classAnnotations = "";
		classAnnotations += "Klasse: " + c.getName();
		ClassAuthor classAuthor = (ClassAuthor) c.getAnnotation(ClassAuthor.class);
		if(classAuthor != null) {
			classAnnotations += "  Autor(en): " + classAuthor.who();
		}
		classAnnotations += "\n";
		Method[] methods = c.getDeclaredMethods(); 
		for (Method method : methods) {
			MethodAuthor methodAuthor = method.getAnnotation(MethodAuthor.class);
			classAnnotations += "  " + method.getName();
			if(methodAuthor != null) {
				classAnnotations += "  Autor(en): "+ methodAuthor.who();
			}
			classAnnotations += "\n";
		}
		classAnnotations += "\n";
		
		return classAnnotations;
	}
	
	private static int i = 0;
	@MethodAuthor(who="Florian Klampfer")
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
