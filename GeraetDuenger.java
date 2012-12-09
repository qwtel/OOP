import javax.xml.ws.soap.MTOM;


/**
 * GeraetDuenger hat immer eine Infomation ueber die Anzahl der Kapazitaet des
 * Behaelters. Dies muss eine Gleitkommazahl sein.
 * 
 * @author Michael Ion
 *
 */
@ClassAuthor(who="Michael Ion")
public class GeraetDuenger implements Geraet {
	
	private float kapazitaet;
	
	public GeraetDuenger(float kapazitaet) {
		this.kapazitaet = kapazitaet;
	}
	@Override
	@MethodAuthor(who="Michael Ion")
	public Number getZahl() {
		return kapazitaet;
	}

}
