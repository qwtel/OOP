/**
 *
 */
@ClassAuthor(who="Florian Klampfer")
public class Bauernhof {

	private final String name;
	private Set<Traktor> traktoren;

	/**
	 * TODO: Zusicherungen
	 */
	public Bauernhof(String name) {
		this.name = name;
		traktoren = new Set<Traktor>();
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public boolean addTraktor(Traktor t) {
		return traktoren.insert(t);
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public boolean removeTraktor(Traktor t) {
		return traktoren.insert(t);
	}

	/**
	 * TODO: Zusicherungen
	 */
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

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitDuengen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t.geraet instanceof GeraetDuenger) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitSaeen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t.geraet instanceof GeraetDrill) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitBiogas() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorBioGas) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBetriebszeitDiesel() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorDiesel) {
				sum += t.getBetriebszeit();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgDieselverbrauch() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorDiesel) {
				sum += t.getTreibstoffverbrauch().intValue();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgDieselverbrauchDuengen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorDiesel) {
				if(t.geraet instanceof GeraetDuenger) {
					sum += t.getTreibstoffverbrauch().intValue();
					count++;
				}
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgDieselverbrauchSaeen() {
		int sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorDiesel) {
				if(t.geraet instanceof GeraetDrill) {
					sum += t.getTreibstoffverbrauch().intValue();
					count++;
				}
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBioGasverbrauch() {
		float sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorBioGas) {
				sum += t.getTreibstoffverbrauch().floatValue();
				count++;
			}
		}
		return (float)sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBioGasverbrauchDuengen() {
		float sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorBioGas) {
				if(t.geraet instanceof GeraetDuenger) {
					sum += t.getTreibstoffverbrauch().floatValue();
					count++;
				}
			}
		}
		return sum/count;
	}

	/**
	 * TODO: Zusicherungen
	 */
	@MethodAuthor(who="Florian Klampfer")
	public float avgBioGasverbrauchSaeen() {
		float sum = 0;
		int count = 0;
		for(Traktor t : traktoren) {
			if(t instanceof TraktorBioGas) {
				if(t.geraet instanceof GeraetDrill) {
					sum += t.getTreibstoffverbrauch().floatValue();
					count++;
				}
			}
		}
		return sum/count;
	}
}
