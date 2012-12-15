/**
 * Ein Doppelkeks besteht aus zwei einfachen Keksen und einer Füllung.
 */
public class DoppelKeks implements Keks {
	private Keks keks1;
	private Keks keks2;
	private Fuellung fuellung;

	/**
	 * @param keks1 Ein einfacher Keks.
	 * @param keks2 Ein einfacher Keks gleicher Form wie keks1.
	 * @param fuellung Eine gültige Fuellung.
	 */
	public DoppelKeks(Keks keks1, Keks keks2, Fuellung fuellung) {
		this.keks1 = keks1;
		this.keks2 = keks2;
		this.fuellung = fuellung;
	}
	
	/**
	 * @return Eine tiefe Kopie von diesem Keks.
	 */
	@Override
	public Keks clone() {
		return  new DoppelKeks(keks1.clone(), keks2.clone(), fuellung);
	}

	@Override
	public String toString() {
		return keks1.toString() + "\nFuellung: " + fuellung.toString();
	}
}
