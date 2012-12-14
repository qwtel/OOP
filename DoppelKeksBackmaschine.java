/**
 * Stellt sicher, dass Backmaschinen eine create Methode mit spezifizierten Teig haben.
 */
public class DoppelKeksBackmaschine implements Backmaschine {
	private Backmaschine backmaschine;
	private EinzelKeks prototyp;
	
	public DoppelKeksBackmaschine(Backmaschine backmaschine, EinzelKeks prototyp) {
		this.backmaschine = backmaschine;
		this.prototyp = prototyp;
	}
	
	@Override
	public EinzelKeks create(Position p) {
		EinzelKeks keks1 = backmaschine.create(p);
		EinzelKeks keks2 = backmaschine.create(p);
		return new DoppelKeks(keks1, keks2, p.getFuellung());
	}
}
