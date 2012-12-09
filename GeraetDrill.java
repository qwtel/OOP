
/**
 * GeraetDrill hat immer eine Infomation ueber die Anzahl der vorhandenen 
 * Saescharen. Dies muss immer eine ganze Zahl sein.
 * 
 * @author Michael Ion
 *
 */
@ClassAuthor(who="Michael Ion")
public class GeraetDrill implements Geraet {
	private int zahl;
	public GeraetDrill(int zahl) {
		this.zahl = zahl;
	}

	@Override
	@MethodAuthor(who="Michael Ion")
	public Number getZahl() {
		return zahl;
	}
	
}
