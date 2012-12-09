
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
