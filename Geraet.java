
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
public interface Geraet {
	@MethodAuthor(who="Michael Ion")
	public Number getZahl(); 

}
