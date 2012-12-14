import java.util.EnumMap;
import java.util.HashMap;

/**
 *
 */
public class Baeckerei {
	private EnumMap<Form, Backmaschine> b;

	public Baeckerei() {
		b = new EnumMap<Form, Backmaschine>(Form.class);
		b.put(Form.Rund, new RundKeksBackmaschine());
		b.put(Form.Mond, new MondKeksBackmaschine());
		b.put(Form.Weihnachtsmann, new WeihnachtsmannKeksBackmaschine());
	}

   	//public Keksdose nimmBestllungAuf(Bestellung bestellung) {
   	//   	Keksdose d = new KeksDose();
   	//   	
   	//   	for(Position p : bestellung) {
   	//   		Backmaschine backmaschine = b.get(p.form);
   	//   		d.add()
   	//   	}
   	//	return null;
   	//}
}
