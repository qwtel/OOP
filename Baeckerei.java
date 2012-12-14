import java.util.EnumMap;

/**
 *
 */
public class Baeckerei {
	private EnumMap<Form, Backmaschine> b;
	private Backmaschine db;

	public Baeckerei() {
		b = new EnumMap<Form, Backmaschine>(Form.class);
		b.put(Form.Rund, new RundKeksBackmaschine());
		b.put(Form.Mond, new MondKeksBackmaschine());
		b.put(Form.Weihnachtsmann, new WeihnachtsmannKeksBackmaschine());
	}

   	public Keksdose nimmBestllungAuf(Bestellung bestellung) {
   	   	Keksdose dose = new Keksdose();
   	   	
   	   	for(Position p : bestellung.getListe()) {
   	   		Backmaschine backmaschine = b.get(p.getForm());

			EinzelKeks k;
			for(int i=0; i<p.getAnzahl(); i++) {
				k = backmaschine.create(p);

				if(p.getFuellung() != null) {
					db = new DoppelKeksBackmaschine(backmaschine, k);
					k = db.create(p);
				}

				dose.add(k);
			}
   	   	}

   		return dose;
   	}
}
