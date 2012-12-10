/**
 * TODO: EVERYTHING
 */
@ClassAuthor(who="Florian Klampfer")
public class Bauernhof {

	private final String name;
	private Set<Traktor> traktoren;

	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Set<Traktor>();
	}

	@MethodAuthor(who="Florian Klampfer")
	public boolean addTraktor(Traktor t) {
		return traktoren.insert(t);
	}

	@MethodAuthor(who="Florian Klampfer")
	public boolean removeTraktor(Traktor t) {
		return traktoren.remove(t);
	}

	// XXX: is this necessary?
	@MethodAuthor(who="Johannes Deml")
	public void changeTraktor(Traktor t, Geraet geraet) {
		t.setGeraet(geraet);
	}
	
	@MethodAuthor(who="Florian Klampfer")
	private Number mapReduce(MapReduce f) {
		for(Traktor t : traktoren) {
			f.map(t);
		}
		return f.reduce();
	}

	@MethodAuthor(who="Florian Klampfer")
	public int avgBetriebszeit() {
		return mapReduce(new AvgBetriebszeitMapReduce(null)).intValue();
	}

	@MethodAuthor(who="Florian Klampfer")
	public int avgBetriebszeitDuengen() {
		return mapReduce(new AvgBetriebszeitMapReduce(
				new TraktorDuengenFilter())).intValue();
	}

	@MethodAuthor(who="Florian Klampfer")
	public int avgBetriebszeitSaeen() {
		return mapReduce(new AvgBetriebszeitMapReduce(
				new TraktorSaeenFilter())).intValue();
	}
	
	@MethodAuthor(who="Florian Klampfer")
	public int avgBetriebszeitDiesel() {
		return mapReduce(new AvgBetriebszeitMapReduce(
				new TraktorDieselFilter())).intValue();
	}

	@MethodAuthor(who="Florian Klampfer")
	public int avgBetriebszeitBiogas() {
		return mapReduce(new AvgBetriebszeitMapReduce(
				new TraktorBiogasFilter())).intValue();
	}
	
   	@MethodAuthor(who="Florian Klampfer")
   	public int avgDieselverbrauch() {
		return mapReduce(new AvgDieselVerbrauchMapReduce(null)).intValue();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public int avgDieselverbrauchDuengen() {
		return mapReduce(new AvgDieselVerbrauchMapReduce(
				new TraktorDuengenFilter())).intValue();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public int avgDieselverbrauchSaeen() {
		return mapReduce(new AvgDieselVerbrauchMapReduce(
				new TraktorSaeenFilter())).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauch() {
		return mapReduce(new AvgBiogasVerbrauchMapReduce(null)).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauchDuengen() {
		return mapReduce(new AvgBiogasVerbrauchMapReduce(
				new TraktorDuengenFilter())).floatValue();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauchSaeen() {
		return mapReduce(new AvgBiogasVerbrauchMapReduce(
				new TraktorSaeenFilter())).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int minSaescharen() {
		return mapReduce(new MinSaescharenMapReduce(null)).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int maxSaescharen() {
		return mapReduce(new MaxSaescharenMapReduce(null)).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int minSaescharenDiesel() {
		return mapReduce(new MinSaescharenMapReduce(
					new TraktorDieselFilter())).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int maxSaescharenDiesel() {
		return mapReduce(new MaxSaescharenMapReduce(
					new TraktorDieselFilter())).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int minSaescharenBiogas() {
		return mapReduce(new MinSaescharenMapReduce(
					new TraktorBiogasFilter())).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int maxSaescharenBiogas() {
		return mapReduce(new MaxSaescharenMapReduce(
					new TraktorBiogasFilter())).intValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float minKapazitaet() {
		return mapReduce(new MinKapazitaetMapReduce(null)).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float maxKapazitaet() {
		return mapReduce(new MaxKapazitaetMapReduce(null)).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float minKapazitaetDiesel() {
		return mapReduce(new MinKapazitaetMapReduce(
					new TraktorDieselFilter())).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float maxKapazitaetDiesel() {
		return mapReduce(new MaxKapazitaetMapReduce(
					new TraktorDieselFilter())).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float minKapazitaetBiogas() {
		return mapReduce(new MinKapazitaetMapReduce(
					new TraktorBiogasFilter())).floatValue();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float maxKapazitaetBiogas() {
		return mapReduce(new MaxKapazitaetMapReduce(
					new TraktorBiogasFilter())).floatValue();
   	}
	
	private interface MapReduce {
		public void map(Traktor t);
		public Number reduce();
	}

	private interface Filter {
		public Traktor filter(Traktor t);
	}

	private class TraktorDieselFilter implements Filter {
		public Traktor filter(Traktor t) {
			return t.getDieselTraktor();
		}
	}

	private class TraktorBiogasFilter implements Filter {
		public Traktor filter(Traktor t) {
			return t.getBiogasTraktor();
		}
	}

	private class TraktorDuengenFilter implements Filter {
		public Traktor filter(Traktor t) {
			return t.getTraktorDuengen();
		}
	}

	private class TraktorSaeenFilter implements Filter {
		public Traktor filter(Traktor t) {
			return t.getTraktorSaeen();
		}
	}

	private abstract class AvgIntMapReduce implements MapReduce {
		protected int value = 0;
		protected int count = 0;
		public abstract void map(Traktor t);
		public Integer reduce() {
			return value/count;
		}
	}
	
	private abstract class AvgFloatMapReduce implements MapReduce {
		protected float value = 0;
		protected int count = 0;
		public abstract void map(Traktor t);
		public Float reduce() {
			return value/count;
		}
	}

	private class AvgBetriebszeitMapReduce extends AvgIntMapReduce {
		private Filter f;
 		public AvgBetriebszeitMapReduce(Filter f) { this.f = f; }
		public void map(Traktor t) {
			if(f != null) { t = f.filter(t); }
			if(t != null) {
				value += t.getBetriebszeit();
				count++;
			}
		}
	}

	private class AvgDieselVerbrauchMapReduce extends AvgIntMapReduce {
		private Filter f1 = new TraktorDieselFilter();
		private Filter f2;
		public AvgDieselVerbrauchMapReduce(Filter f) { this.f2 = f; }
		public void map(Traktor t) {
			t = f1.filter(t);
			if(f2 != null && t != null) { t = f2.filter(t); }
			if(t != null) {
				value += t.getTreibstoffverbrauch().intValue();
				count++;
			}
		}
	}
	
	private class AvgBiogasVerbrauchMapReduce extends AvgFloatMapReduce {
		private Filter f1 = new TraktorBiogasFilter();
		private Filter f2;
		public AvgBiogasVerbrauchMapReduce(Filter f) { this.f2 = f; }
		public void map(Traktor t) {
			t = f1.filter(t);
			if(f2 != null && t != null) { t = f2.filter(t); }
			if(t != null) {
				value += t.getTreibstoffverbrauch().floatValue();
				count++;
			}
		}
	}

	private abstract class ExtremeSaescharenMapReduce implements MapReduce {
	   	protected int min = Integer.MAX_VALUE;
	   	protected int max = Integer.MIN_VALUE;
	   	private int value;
		private Filter f1 = new TraktorSaeenFilter();
		private Filter f2;
		public ExtremeSaescharenMapReduce(Filter f) { this.f2 = f; }
		public void map(Traktor t) {
			t = f1.filter(t);
			if(f2 != null && t != null) { t = f2.filter(t); }
			if(t != null) {
				if((value = t.getZahl().intValue()) < min) { min = value; }
				if((value = t.getZahl().intValue()) > max) { max = value; }
			}
		}
	}

	private abstract class ExtremeKapazitaetMapReduce implements MapReduce {
	   	protected float min = Float.POSITIVE_INFINITY;
	   	protected float max = Float.NEGATIVE_INFINITY;
	   	private float value;
		private Filter f1 = new TraktorDuengenFilter();
		private Filter f2;
		public ExtremeKapazitaetMapReduce(Filter f) { this.f2 = f; }
		public void map(Traktor t) {
			t = f1.filter(t);
			if(f2 != null && t != null) { t = f2.filter(t); }
			if(t != null) {
				if((value = t.getZahl().floatValue()) < min) { min = value; }
				if((value = t.getZahl().floatValue()) > max) { max = value; }
			}
		}
	}

	private class MinSaescharenMapReduce extends ExtremeSaescharenMapReduce {
		public MinSaescharenMapReduce(Filter f) { super(f); }
		public Integer reduce() { return min; }
	}
	
	private class MaxSaescharenMapReduce extends ExtremeSaescharenMapReduce {
		public MaxSaescharenMapReduce(Filter f) { super(f); }
		public Integer reduce() { return max; }
	}

	private class MinKapazitaetMapReduce extends ExtremeKapazitaetMapReduce {
		public MinKapazitaetMapReduce(Filter f) { super(f); }
		public Float reduce() { return min; }
	}
	
	private class MaxKapazitaetMapReduce extends ExtremeKapazitaetMapReduce {
		public MaxKapazitaetMapReduce(Filter f) { super(f); }
		public Float reduce() { return max; }
	}
}
