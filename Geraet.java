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
	Traktor getTraktorDuengen(Traktor t) {
		return null;
	}

	@MethodAuthor(who="Florian Klampfer")
	Traktor getTraktorSaeen(Traktor t) {
		return null;
	}
}
