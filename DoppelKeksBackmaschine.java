/**
 * 
 */
class DoppelKeksBackmaschine implements Backmaschine {
	private Keks prototyp;
	
	public DoppelKeksBackmaschine(Keks prototyp) {
		this.prototyp = prototyp;
	}
	
	@Override
	public Keks create(Position p) {
		Keks keks1 = prototyp.clone();
		Keks keks2 = prototyp.clone();
		return new DoppelKeks(keks1, keks2, p.getFuellung());
	}
}
