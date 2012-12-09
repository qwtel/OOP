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
		bauernhoefe.insert(new Bauernhof("OrwellsFarm"));
		bauernhoefe.insert(new Bauernhof("oldMcDonaldsFarm"));
		bauernhoefe.insert(new Bauernhof("FarmVille"));
		
		
		/*
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
		*/
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


