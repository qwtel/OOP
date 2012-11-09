/**
 * ClearBox
 *
 * Instanzen von Box stellen aus druckbaren Zeichen geformte Rechtecke dar.
 *
 * Verwendet als Zeichen für die Ränder immer  * und für den Inhalt das 
 * Leerzeichen. 
 *
 * @author Michael Ion, Florian Klampfer
 */
public class ClearBox extends ClassicBox {

	/**
	 * Das Verhältnis von Breite zu Höhe. 
	 * Das Verhätnis bleibt bestehen. (history constraint)
	 */
	private final double ratio;

    /**
     * Erzeugt eine ClearBox.
	 *
	 * @param width Eine Zahl größer 1.
	 * @param height Eine Zahl größer 1.
	 */
	public ClearBox(double width, double height) {
		super(width, height, '*', ' ');
		ratio = width/height;
	}

	/**
	 * Gibt die Möglichkeit das Seitenverhältnis abzufragen. 
	 *
	 * @return Breite dividiert durch Höhe.
	 */
	public double getRatio() {
		return ratio;
	}
}
