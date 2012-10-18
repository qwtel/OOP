/**
 * Represents a musician.
 * @author Florian Klampfer
 */
public class Musician {
	private final String name;
	private final String tel;
	private final String instrument;

	public Musician(String name, String tel, String instrument) {
		this.name = name;
		this.tel = tel;
		this.instrument = instrument;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getInstrument() {
		return instrument;
	}

	@Override
	public String toString() {
		return "Name: "+name+" Tel: "+tel+" Ins: "+instrument;

	}
}
