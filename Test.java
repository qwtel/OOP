import java.lang.reflect.Method;

/**
 * Handels all TestCases, includes main method.
 */
@ClassAuthor(who="Florian Klampfer, Johannes Deml, Michael Ion")
public class Test {
	
	@MethodAuthor(who="Florian Klampfer, Johannes Deml, Michael Ion")
	public static void main(String[] args) throws Exception {

		System.out.println(getClassAnnotation("Bauernhof"));
		System.out.println(getClassAnnotation("ClassAuthor"));
		System.out.println(getClassAnnotation("Geraet"));
		System.out.println(getClassAnnotation("GeraetDrill"));
		System.out.println(getClassAnnotation("GeraetDuenger"));
		System.out.println(getClassAnnotation("Identifizierbar"));
		System.out.println(getClassAnnotation("MethodAuthor"));
		System.out.println(getClassAnnotation("Set"));
		System.out.println(getClassAnnotation("Test"));
		System.out.println(getClassAnnotation("Traktor"));
		System.out.println(getClassAnnotation("TraktorBiogas"));
		System.out.println(getClassAnnotation("TraktorDiesel"));
		Set b = new Set();
	
		b.insert(new Bauernhof("OrwellsFarm"));
		b.insert(new Bauernhof("oldMcDonaldsFarm"));
		b.insert(new Bauernhof("FarmVille"));
		
		find(b, "OrwellsFarm").add(new TraktorBiogas(new GeraetDrill(5)));
		find(b, "OrwellsFarm").add(new TraktorBiogas(new GeraetDuenger(2.3f)));
		find(b, "OrwellsFarm").add(new TraktorDiesel(new GeraetDrill(12)));
		find(b, "OrwellsFarm").add(new TraktorDiesel(new GeraetDuenger(1.6f)));
		find(b, "OrwellsFarm").add(new TraktorBiogas(new GeraetDrill(8)));
		find(b, "OrwellsFarm").add(new TraktorBiogas(new GeraetDrill(8)));

		find(b, "OrwellsFarm").find(0).incStunden(3);
		find(b, "OrwellsFarm").find(1).incStunden(3);
		find(b, "OrwellsFarm").find(2).incStunden(3);
		find(b, "OrwellsFarm").find(3).incStunden(3);
		find(b, "OrwellsFarm").find(4).incStunden(3);
		find(b, "OrwellsFarm").find(5).incStunden(30);
		find(b, "OrwellsFarm").remove(5);

		b.insert(new Bauernhof("NullBauernhof"));
		find(b, "NullBauernhof").add(new TraktorBiogas(new GeraetDrill(0)));
		find(b, "NullBauernhof").add(new TraktorBiogas(new GeraetDrill(0)));

		doTest("avgBetriebszeit", 
				find(b, "OrwellsFarm").avgBetriebszeit(), 3);
		doTest("avgBetriebszeitDiesel", 
				find(b, "OrwellsFarm").avgBetriebszeitDiesel(), 3);
		doTest("avgBetriebszeitBiogas", 
				find(b, "OrwellsFarm").avgBetriebszeitBiogas(), 3);
		doTest("avgBetriebszeitDuengen", 
				find(b, "OrwellsFarm").avgBetriebszeitDuengen(), 3);
		doTest("avgBetriebszeitSaeen", 
				find(b, "OrwellsFarm").avgBetriebszeitSaeen(), 3);

		doTest("maxSaescharen", 
				find(b, "OrwellsFarm").maxSaescharen(), 12);
		doTest("maxSaescharenBiogas", 
				find(b, "OrwellsFarm").maxSaescharenBiogas(), 8);
		doTest("maxSaescharenDiesel", 
				find(b, "OrwellsFarm").maxSaescharenDiesel(), 12);
			
		doTest("minSaescharen", 
				find(b, "OrwellsFarm").minSaescharen(), 5);
		doTest("minSaescharenBiogas", 
				find(b, "OrwellsFarm").minSaescharenBiogas(), 5);
		doTest("minSaescharenDiesel", 
				find(b, "OrwellsFarm").minSaescharenDiesel(), 12);
		
		doTest("maxKapazitaet", 
				find(b, "OrwellsFarm").maxKapazitaet(), 2.3f);
		doTest("maxKapazitaetBiogas", 
				find(b, "OrwellsFarm").maxKapazitaetBiogas(), 2.3f);
		doTest("maxKapazitaetDiesel", 
				find(b, "OrwellsFarm").maxKapazitaetDiesel(), 1.6f);
		
		doTest("minKapazitaet", 
				find(b, "OrwellsFarm").minKapazitaet(), 1.6f);
		doTest("minKapazitaetBiogas", 
				find(b, "OrwellsFarm").minKapazitaetBiogas(), 2.3f);
		doTest("minKapazitaetDiesel", 
				find(b, "OrwellsFarm").minKapazitaetDiesel(), 1.6f);

		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBetriebszeit(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBetriebszeitDiesel(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBetriebszeitBiogas(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBetriebszeitDuengen(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBetriebszeitSaeen(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgDieselverbrauch(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgDieselverbrauchDuengen(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgDieselverbrauchSaeen(), 0);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBioGasverbrauch(), .0f);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBioGasverbrauchDuengen(), .0f);
		doTest("Divison durch 0", 
				find(b, "NullBauernhof").avgBioGasverbrauchSaeen(), .0f);

	}

	@MethodAuthor(who="Florian Klampfer")
	private static Bauernhof find(Set b, String name) {
		Identifizierbar o = b.find(name);
		if(o instanceof Bauernhof) {
			return (Bauernhof)o;
		}
		return null;
	}

	/**
	 * @param className Name einer existierenden Klasse.
	 * @return Informationen ueber die Klasse in einem String
	 * @throws ClassNotFoundException Wird geworfen, wenn der erhaltene Name
	 * 								  keiner Klasse zugwiesen werden kann.
	 */
	@MethodAuthor(who="Johannes Deml")
	private static String getClassAnnotation(String className) 
			throws ClassNotFoundException{
		String classAnnotations = "";
		classAnnotations += "Klasse: " + Class.forName(className).getName();
		ClassAuthor classAuthor = null;
		if(Class.forName(className).isAnnotationPresent(ClassAuthor.class)) {
			classAuthor = (ClassAuthor)Class.forName(className).getAnnotation(
				ClassAuthor.class);
		}
		if(classAuthor != null) {
			classAnnotations += "  Autor(en): " + classAuthor.who();
		}
		classAnnotations += "\n";
		Method[] methods = Class.forName(className).getDeclaredMethods(); 
		for (Method method : methods) {
			MethodAuthor methodAuthor = method.getAnnotation(
				MethodAuthor.class);
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
	/**
	 * @param description Informationen ueber den Testversuch
	 * @param result Die berechnete Loesung fuer den Test
	 * @param expected Die erwartete Loesung fuer den Test
	 */
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
