/**
 * Represents a musician.
 * @author Floran Klampfer
 */
class Musician {
	private String name;
	private String tel;
	private String instrument;

	public Musician(String name, String tel, String instrument) {
		this.name = name;
		this.tel = tel;
		this.name = instrument;
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
}
