
/**
 * GeraetDuenger hat immer eine Infomation ueber die Anzahl der Kapazitaet des
 * Behaelters. Dies muss eine Gleitkommazahl sein.
 * 
 * @author Michael Ion
 *
 */

public class GeraetDuenger implements Geraet {
	private float kapazitaet;
	
	public GeraetDuenger(float kapazitaet) {
		this.kapazitaet = kapazitaet;
	}
	@Override
	public Number getZahl() {
		return kapazitaet;
	}

}
