
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
