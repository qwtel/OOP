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
	 * Wird für den Vergleich mittels shorter verwendet - genau Bedeutung von
	 * Untertypen abhängig.
	 * @see #shorter(ElapsedTime)
	 * @see #setTime(double)
	 */
	private double time;

	/**
	 * Setzt die Zeit auf 0.
	 */
	public ElapsedTime() {
		this.time = 0.0;
	}

	/**
	 * Erlaubt abgeleiteten Klassen das Setzen der Zeit. 
	 * @param time Die zu setzende Zeit.
	 * @see #shorter(ElapsedTime)
	 */
	protected final void setTime(double time) {
		this.time = time;
	}

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
		return (this.time < other.time);
	}

	/**
	 * Liefert die Anzahl durchgeführter Messungen – genaue Bedeutung von 
	 * Untertypen abhängig.
	 *
	 * @return Die Anzahl durchgeführter Messungen.
	 */
	abstract public int count();
}
