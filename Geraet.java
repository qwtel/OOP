/**
 * Geraet ist eine Oberklasse von GeraetDrill und GeraetDuenger.
 * Jedes Geraet hat eine eine eindeutige Information ueber die Komponente selbst
 * (GeraetDrill hat Saeschare und GeraetDuenger hat eine Information ueber
 * die Fassungskapazitaet des Duegngerbehaelters)
 * 
 * @author Michael Ion
 *
 */
@ClassAuthor(who="Michael Ion")
public abstract class Geraet {

	@MethodAuthor(who="Michael Ion")
	public abstract Number getZahl(); 

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitDuengen(Traktor t) {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBetriebszeitSaeen(Traktor t) {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchDuengen(Traktor t) {
		return new Tupel(0, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getDieselVerbrauchSaeen(Traktor t) {
		return new Tupel(0, 0);
	}
	
	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchDuengen(Traktor t) {
		return new Tupel(.0f, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	Tupel getBiogasVerbrauchSaeen(Traktor t) {
		return new Tupel(.0f, 0);
	}

	@MethodAuthor(who="Florian Klampfer")
	int getSaescharen() {
		return 0;
	}
	
	@MethodAuthor(who="Florian Klampfer")
	float getKapazitaet() {
		return .0f;
	}
}
