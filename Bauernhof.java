/**
 * Verwaltet Informationen über einen Bauernhof und ermöglicht statistische 
 * Auswertungen über diesen Bauernhof ermöglicht. 
 */
@ClassAuthor(who="Florian Klampfer")
public class Bauernhof implements Identifizierbar {

	private final String name;
	private Set traktoren;

	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Set();
	}

	@MethodAuthor(who="Florian Klampfer")
	public void add(Traktor t) {
		traktoren.insert(t);
	}

	@MethodAuthor(who="Florian Klampfer")
	public boolean remove(int seriennummer) {
		return traktoren.remove(seriennummer);
	}

	/**
	 * @param seriennummer Die Nummer die den Traktor identifiziert
	 * @return Die Instanz des Traktors sofern er existiert, sonst null
	 */
	@MethodAuthor(who="Johannes Deml")
	public Traktor find(int seriennummer) {
		Object o = traktoren.find(seriennummer);

		if(o instanceof Traktor) {
			return (Traktor)o;
		}
		return null;
	}

	/**
	 * @param seriennummer Die Nummer die den Traktor identifiziert
	 * @param geraet Das Geraet, das dem Traktor zugewiesen wird
	 * 				 Das alte Geraet verschwindet
	 */
	@MethodAuthor(who="Johannes Deml")
	public void change(int seriennummer, Geraet geraet) {
		Traktor t = find(seriennummer);
		t.setGeraet(geraet);
	}

	/**
	 * @return Der Name des Hofs.
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	public String id() {
		return name;
	}
	
	/**
	 * Berechnet ein Ergebnis über allen Traktoren.
	 * @see MapReduce
	 */
	@MethodAuthor(who="Florian Klampfer")
	private Number mapReduce(MapReduce f) {
		for(Object o : traktoren) {
			if(o instanceof Traktor) {
				Traktor t = (Traktor)o;
				f.map(t);
			}
		}
		return f.reduce();
	}

	/*
	 * Verschiedene statistischer Methoden über den Bauernhof:
	 */
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
	
	/**
	 * Implementiert einen Algorithmus in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private abstract class MapReduce {
		private Filter f;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public MapReduce(Filter f) { this.f = f; }

   		@MethodAuthor(who="Florian Klampfer")
		public final void map(Traktor t) {
			if(f != null) { t = f.filter(t); }
			if(t != null) { innerMap(t); }
		}

   		@MethodAuthor(who="Florian Klampfer")
		public abstract Number reduce();

   		@MethodAuthor(who="Florian Klampfer")
		protected abstract void innerMap(Traktor t);
	}

	/**
	 * Implementiert eine Betriebszeit Durschnittsbildung in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class AvgBetriebszeitMapReduce extends MapReduce {
		private int value = 0;
		private int count = 0;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
 		public AvgBetriebszeitMapReduce(Filter f) { super(f); }

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected void innerMap(Traktor t) {
			value += t.getBetriebszeit();
			count++;
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Integer reduce() { 
			if(count != 0) { return value/count; }
			return 0;
		}
	}

	/**
	 * Implementiert eine Dieselverbrauch Durschnittsbildung in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class AvgDieselVerbrauchMapReduce extends MapReduce {
		private int value = 0;
		private int count = 0;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public AvgDieselVerbrauchMapReduce(Filter f) { 
			super(new TraktorDieselFilter(f));
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected void innerMap(Traktor t) {
			value += t.getTreibstoffverbrauch().intValue();
			count++;
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Integer reduce() { 
			if(count != 0) { return value/count; }
			return 0;
		}
	}
	
	/**
	 * Implementiert eine Biogasverbrauch Durschnittsbildung in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class AvgBiogasVerbrauchMapReduce extends MapReduce {
		private float value = 0;
		private int count = 0;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public AvgBiogasVerbrauchMapReduce(Filter f) {
			super(new TraktorBiogasFilter(f));
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected void innerMap(Traktor t) {
			value += t.getTreibstoffverbrauch().floatValue();
			count++;
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Float reduce() { 
			if(count != 0) { return value/count; }
			return .0f;
		}
	}

	/**
	 * Findet einen Saescharen Extremwert in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private abstract class ExtremeSaescharenMapReduce extends MapReduce {
	   	protected int min = Integer.MAX_VALUE;
	   	protected int max = Integer.MIN_VALUE;
	   	private int value;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public ExtremeSaescharenMapReduce(Filter f) {
			super(new TraktorSaeenFilter(f));
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected void innerMap(Traktor t) {
			if((value = t.getAnzahl().intValue()) < min) { min = value; }
			if((value = t.getAnzahl().intValue()) > max) { max = value; }
		}
	}

	/**
	 * Findet einen Kapazitaets Extremwert in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private abstract class ExtremeKapazitaetMapReduce extends MapReduce {
	   	protected float min = Float.POSITIVE_INFINITY;
	   	protected float max = Float.NEGATIVE_INFINITY;
	   	private float value;

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public ExtremeKapazitaetMapReduce(Filter f) {
			super(new TraktorDuengenFilter(f)); 
		}

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected void innerMap(Traktor t) {
			if((value = t.getAnzahl().floatValue()) < min) { min = value; }
			if((value = t.getAnzahl().floatValue()) > max) { max = value; }
		}
	}

	/**
	 * Findet einen Saescharen Minimum in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class MinSaescharenMapReduce extends ExtremeSaescharenMapReduce {

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public MinSaescharenMapReduce(Filter f) { super(f); }

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Integer reduce() { return min; }
	}
	
	/**
	 * Findet einen Saescharen Maximum in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class MaxSaescharenMapReduce extends ExtremeSaescharenMapReduce {

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public MaxSaescharenMapReduce(Filter f) { super(f); }

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Integer reduce() { return max; }
	}

	/**
	 * Findet einen Kapazitaets Minimum in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class MinKapazitaetMapReduce extends ExtremeKapazitaetMapReduce {

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public MinKapazitaetMapReduce(Filter f) { super(f); }

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Float reduce() { return min; }
	}
	
	/**
	 * Findet einen Kapazitaets Maximum in zwei Schritten.
	 * Im ersten Schritt wird wiederholt map mit verschiedenen Traktoren
	 * aufgerufen. Anschließen liefert reduce das Ergebnis.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class MaxKapazitaetMapReduce extends ExtremeKapazitaetMapReduce {

		/**
		 * @param f Ein Filter wenn im map-Schritt bestimmte Traktoren gefiltert
		 * werden sollen. Ansonsten null.
		 */
		public MaxKapazitaetMapReduce(Filter f) { super(f); }

   		@MethodAuthor(who="Florian Klampfer")
		@Override
		public Float reduce() { return max; }
	}

	/**
	 * Filtert Traktoren nach einem bestimmten Kriterium.
	 * Ein Filter kann weitere Filter beeinhalten, die "rekursiv" abgearbeitet
	 * werden.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private abstract class Filter {
		private Filter f;
		public Filter() { this(null); }
		public Filter(Filter f) { this.f = f; }

		/**
		 * @param t Darf nicht null sein.
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		public final Traktor filter(Traktor t) {
			if(f != null) { t = f.filter(t); }
			if(t != null) { t = innerFilter(t); }
			return t;
		}

		/**
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		protected abstract Traktor innerFilter(Traktor t);
	}

	/**
	 * Filtert Traktoren nach einem bestimmten Kriterium.
	 * Ein Filter kann weitere Filter beeinhalten, die "rekursiv" abgearbeitet
	 * werden.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class TraktorDieselFilter extends Filter {
		public TraktorDieselFilter() { super(null); }
		public TraktorDieselFilter(Filter f) { super(f); }

		/**
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected Traktor innerFilter(Traktor t) {
			return t.getTraktorDiesel();
		}
	}

	/**
	 * Filtert Traktoren nach einem bestimmten Kriterium.
	 * Ein Filter kann weitere Filter beeinhalten, die "rekursiv" abgearbeitet
	 * werden.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class TraktorBiogasFilter extends Filter {
		public TraktorBiogasFilter() { super(null); }
		public TraktorBiogasFilter(Filter f) { super(f); }

		/**
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected Traktor innerFilter(Traktor t) {
			return t.getTraktorBiogas();
		}
	}

	/**
	 * Filtert Traktoren nach einem bestimmten Kriterium.
	 * Ein Filter kann weitere Filter beeinhalten, die "rekursiv" abgearbeitet
	 * werden.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class TraktorDuengenFilter extends Filter {
		public TraktorDuengenFilter() { super(null); }
		public TraktorDuengenFilter(Filter f) { super(f); }

		/**
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected Traktor innerFilter(Traktor t) {
			return t.getTraktorDuengen();
		}
	}

	/**
	 * Filtert Traktoren nach einem bestimmten Kriterium.
	 * Ein Filter kann weitere Filter beeinhalten, die "rekursiv" abgearbeitet
	 * werden.
	 */
   	@ClassAuthor(who="Florian Klampfer")
	private class TraktorSaeenFilter extends Filter {
		public TraktorSaeenFilter() { super(null); }
		public TraktorSaeenFilter(Filter f) { super(f); }

		/**
		 * @return t wenn das Kriterium erfüllt ist, null ansonsten.
		 */
   		@MethodAuthor(who="Florian Klampfer")
		@Override
		protected Traktor innerFilter(Traktor t) {
			return t.getTraktorSaeen();
		}
	}
}
