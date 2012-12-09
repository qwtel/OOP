
/**
 * GeraetDrill hat immer eine Infomation ueber die Anzahl der besessenen 
 * Saescharen. Dies muss immer eine ganze Zahl sein.
 * 
 * @author Michael Ion
 *
 */

public class GeraetDrill implements Geraet {
	private int zahl;
	public GeraetDrill(int zahl) {
		this.zahl = zahl;
	}

	@Override
	public Number getZahl() {
		return zahl;
	}
	
}
