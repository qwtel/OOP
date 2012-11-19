/**
 * ElapsedTime
 *
 * Stellt die gemessene Zeit eines Vorgangs (zB einer Programmausführung) dar 
 * und ist ein Untertyp von Shorter, wobei shorter zwei Instanzen von 
 * ElapsedTime hinsichtlich der gemessenen Zeit vergleicht. 
 *
 * @author Florian Klampfer
 */
public abstract class ElapsedTime implements Shorter<ElapsedTime> {

 	/**
	 * Gibt genau dann true zurück, wenn this (auf nicht näher bestimmte Weise) 
	 * kürzer als das übergebene Argument ist.
	 *
	 * @param other Die zu vergleichende ElapsedTime.
	 * @return true, wenn this kürzer als other ist.
	 * @see #setTime(double)
	 */
	@Override
	public final boolean shorter(ElapsedTime other) {
		return (this.getTime() < other.getTime());
	}

	abstract double getTime();

	/**
	 * Liefert die Anzahl durchgeführter Messungen – genaue Bedeutung von 
	 * Untertypen abhängig.
	 *
	 * @return Die Anzahl durchgeführter Messungen.
	 */
	abstract public int count();
}
