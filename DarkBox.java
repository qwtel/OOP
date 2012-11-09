/**
 * DarkBox
 *
 * Instanzen von Box stellen aus druckbaren Zeichen geformte Rechtecke dar.
 *
 * Das Zeichen für den Inhalt entspricht stets dem Zeichen für die Ränder.
 *
 * @author Florian Klampfer
 */
public class DarkBox extends ClassicBox {

    /**
     * Erzeugt eine DarkBox.
	 *
	 * @param width Eine Zahl größer 1.
	 * @param height Eine Zahl größer 1.
	 * @param fill Das Zeichen der DarkBox (entspricht Rand und Inhalt)
	 */
	public DarkBox(double width, double height, char fill) {
		super(width, height, fill, fill);
	}

	/**
	 * Gibt die Möglichkeit, das Zeichen zu ändern.
	 *
	 * @param fill Das neue Zeichen der DarkBox (entspricht Rand und Inhalt)
	 */
	@Override
	public void setFill(char fill) {
		super.setBorder(fill);
		super.setFill(fill);
	}
}
