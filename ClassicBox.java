/**
 * ClassicBox
 *
 * Eine AbstractBox welche eine Füllung und einen Rand besitzt.
 *
 * Die Ränder einer ClassicBox können aus anderen Zeichen bestehen als der 
 * Inhalt.
 *
 * Höhe und Breite (jeweils als Anzahl der Zeichen angegeben) stehen in einem 
 * fixen Verhältnis zueinander. 
 *
 * @author Johannes Deml, Florian Klampfer
 */
public abstract class ClassicBox extends AbstractBox {
	private char border;
    private char fill;

	/**
	 * Setzt die Zeichen für Rand und Inhalt einer ClassicBox.
	 *
	 * @param width Eine Zahl größer 1.
	 * @param height Eine Zahl größer 1.
     * @param border Ein druckbarers Zeichen.
     * @param fill Ein druckbares Zeichen.
	 */
	public ClassicBox(double width, double height, char border, char fill) {
		super(width, height);
		this.border = border;
		this.fill = fill;
	}

	/**
	 * Zeichnet eine Box mit Rand in ein 2D Array.
	 *
	 * @param charArray Ein 2D char-Array das exakt der Größe der skalierten Box 
	 *         entspricht
	 * @param width Die Breite der skalierten Box
	 * @param height Die Höhe der skalierten Box
	 */
	@Override
	public void fillArray(char[][] charArray, int tempWidth, int tempHeight) {
		for(int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				charArray[w][h] = fill;
			}
		}

		for(int w=0; w<tempWidth; w++) {
			charArray[w][0] = border;
			charArray[w][tempHeight-1] = border;
		}

		for(int h=0; h<tempHeight; h++) {
			charArray[0][h] = border;
			charArray[tempWidth-1][h] = border;
		}
	}

	/**
	 * @return Das Zeichen für den Rand. 
	 */
	protected char getBorder() {
		return border;
	}

	/**
	 * @return Das Zeichen für den Inhalt. 
	 */
	protected char getFill() {
		return fill;
	}

	/**
     * @param border Ein druckbarers Zeichen.
	 */
	protected void setBorder(char border) {
		this.border = border;
	}

	/**
     * @param fill Ein druckbares Zeichen.
	 */
	protected void setFill(char fill) {
		this.fill = fill;
	}

   	@Override
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;

		if (!(o instanceof ClassicBox)) return false;
		ClassicBox other = (ClassicBox)o;
		return (this.border == other.border) && (this.fill == other.fill);
	}
}
