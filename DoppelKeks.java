/**
 *
 */
public class DoppelKeks implements Keks {
	private EinzelKeks keks1;
	private EinzelKeks keks2;
	private Fuellung fuellung;

	public DoppelKeks(EinzelKeks keks1, EinzelKeks keks2, Fuellung fuellung) {
		this.keks1 = keks1;
		this.keks2 = keks2;
		this.fuellung = fuellung;
	}
}
