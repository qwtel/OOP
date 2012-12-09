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
		return traktoren.insert(t);
	}

	// XXX: is this necessary?
	@MethodAuthor(who="Johannes Deml")
	public void changeTraktor(Traktor t, Geraet geraet) {
		t.setGeraet(geraet);
	}

	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeit() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			sum += t.getBetriebszeit();
			count++;
		}
		return (float)sum/count;
	}

	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitDuengen() {
		Tupel sum = new Tupel(0, 0);
		for(Traktor t : traktoren) {
			sum.addIntValue(t.getBetriebszeitDuengen());
		}
		return (float)sum.intValue()/sum.getCount();
	}

	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitSaeen() {
		Tupel sum = new Tupel(0, 0);
		for(Traktor t : traktoren) {
			sum.addIntValue(t.getBetriebszeitSaeen());
		}
		return (float)sum.intValue()/sum.getCount();
	}

	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitBiogas() {
		Tupel sum = new Tupel(0, 0);
		for(Traktor t : traktoren) {
			sum.addIntValue(t.getBetriebszeitBiogas());
		}
		return (float)sum.intValue()/sum.getCount();
	}

	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitDiesel() {
		Tupel sum = new Tupel(0, 0);
		for(Traktor t : traktoren) {
			sum.addIntValue(t.getBetriebszeitDiesel());
		}
		return (float)sum.intValue()/sum.getCount();
	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float avgDieselverbrauch() {
   		Tupel sum = new Tupel(0, 0);
   		for(Traktor t : traktoren) {
			sum.addIntValue(t.getDieselVerbrauch());
   		}
   		return (float)sum.intValue()/sum.getCount();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public float avgDieselverbrauchDuengen() {
   		Tupel sum = new Tupel(0, 0);
   		for(Traktor t : traktoren) {
			sum.addIntValue(t.getDieselVerbrauchDuengen());
   		}
   		return (float)sum.intValue()/sum.getCount();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public float avgDieselverbrauchSaeen() {
   		Tupel sum = new Tupel(0, 0);
   		for(Traktor t : traktoren) {
			sum.addIntValue(t.getDieselVerbrauchSaeen());
   		}
   		return (float)sum.intValue()/sum.getCount();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauch() {
   		Tupel sum = new Tupel(.0f, 0);
   		for(Traktor t : traktoren) {
			sum.addFloatValue(t.getBiogasVerbrauch());
   		}
   		return sum.floatValue()/sum.getCount();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauchDuengen() {
   		Tupel sum = new Tupel(.0f, 0);
   		for(Traktor t : traktoren) {
			sum.addFloatValue(t.getBiogasVerbrauchDuengen());
   		}
   		return sum.floatValue()/sum.getCount();
   	}
   	
   	@MethodAuthor(who="Florian Klampfer")
   	public float avgBioGasverbrauchSaeen() {
   		Tupel sum = new Tupel(.0f, 0);
   		for(Traktor t : traktoren) {
			sum.addFloatValue(t.getBiogasVerbrauchSaeen());
   		}
   		return sum.floatValue()/sum.getCount();
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMinSaescharen() {
		int min = Integer.MAX_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharen()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMaxSaescharen() {
		int max = Integer.MIN_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharen()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMinSaescharenDiesel() {
		int min = Integer.MAX_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharenDiesel()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMaxSaescharenDiesel() {
		int max = Integer.MIN_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharenDiesel()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMinSaescharenBiogas() {
		int min = Integer.MAX_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharenBiogas()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public int getMaxSaescharenBiogas() {
		int max = Integer.MIN_VALUE;
		int z;
   		for(Traktor t : traktoren) {
			if((z = t.getSaescharenBiogas()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMinKapazitaet() {
		float min = Float.POSITIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaet()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMaxKapazitaet() {
		float max = Float.NEGATIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaet()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMinKapazitaetDiesel() {
		float min = Float.POSITIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaetDiesel()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMaxKapazitaetDiesel() {
		float max = Float.NEGATIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaetDiesel()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMinKapazitaetBiogas() {
		float min = Float.POSITIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaetBiogas()) < min) {
            	min = z;
			}
   		}
   		return min;
   	}

   	@MethodAuthor(who="Florian Klampfer")
   	public float getMaxKapazitaetBiogas() {
		float max = Float.NEGATIVE_INFINITY;
		float z;
   		for(Traktor t : traktoren) {
			if((z = t.getKapazitaetBiogas()) > max) {
            	max = z;
			}
   		}
   		return max;
   	}
}
