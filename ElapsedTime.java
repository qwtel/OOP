/**
 * ElapsedTime
 *
 * Stellt die gemessene Zeit eines Vorgangs (zB einer Programmausführung) dar 
 * und ist ein Untertyp von Shorter, wobei shorter zwei Instanzen von 
 * ElapsedTime hinsichtlich der gemessenen Zeit vergleicht. 
 *
 * @author TODO, Florian Klampfer
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime> {

	private double time;

	public ElapsedTime() {
		this.time = 0.0;
	}

	protected final void setTime(double time) {
		this.time = time;
	}

 	/**
	 * Gibt genau dann true zurück, wenn this (auf nicht näher bestimmte Weise) 
	 * kürzer als das übergebene Argument ist.
	 *
	 * @param other Das zu vergleichende Element.
	 * @return true, wenn this kürzer als other ist.
	 */
	@Override
	public final boolean shorter(ElapsedTime other) {
		return (this.time < other.time);
	}

	/**
	 * Liefert die Anzahl durchgeführter Messungen – genaue Bedeutung von 
	 * Untertypen abhängig.
	 */
	abstract public int count();
}
