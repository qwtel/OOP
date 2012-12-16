import java.util.EnumMap;

/**
 * Erstellt Keksdosen aus Bestellungen.
 */
public class Baeckerei {

	/**
	 * Muss Backmaschinen fuer alle Keksformen enthalten.
	 * @see From
	 */
	private EnumMap<Form, Backmaschine> b;

	public Baeckerei() {
		b = new EnumMap<Form, Backmaschine>(Form.class);
		b.put(Form.Rund, new RundKeksBackmaschine());
		b.put(Form.Mond, new MondKeksBackmaschine());
		b.put(Form.Weihnachtsmann, new WeihnachtsmannKeksBackmaschine());
	}

	/**
	 * @param bestellung Eine gueltige Bestellung.
	 * @return Eine Keksdose entsprechend der Bestellung.
	 */
   	public Keksdose nimmBestellungAuf(Bestellung bestellung) {
   	   	Keksdose dose = new Keksdose();

   	   	for(Position p : bestellung.getListe()) {
   	   		Backmaschine backmaschine = b.get(p.getForm());
			Keks k = backmaschine.create(p);

			if(p.getFuellung() != null) {
				backmaschine = new DoppelKeksBackmaschine(k);
				k = backmaschine.create(p);
			}

			dose.add(k);
			for(int i=0; i<p.getAnzahl()-1; i++) {
				dose.add(k.clone());
			}
   	   	}

   		return dose;
   	}
}
