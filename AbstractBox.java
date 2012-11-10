/**
 * AbstractBox
 *
 * Ein Pict mit Höhe und Breite.
 *
 * Höhe und Breite (jeweils als Anzahl der Zeichen angegeben) stehen in einem 
 * fixen Verhältnis zueinander. 
 *
 * @author Johannes Deml, Florian Klampfer
 */
public abstract class AbstractBox implements Pict {

	/*
	 * Das Verhältnis von Höhe zu Breite bleibt bestehen. (history constraint)
	 */
	private double width;
	private double height;

	/**
	 * Legt die Größe der Box fest.
	 *
	 * @param width Eine Zahl größer 1.
	 * @param height Eine Zahl größer 1.
	 */
	public AbstractBox(double width, double height) {
		this.width = width;
		this.height = height;
	}

	/**
	 * Ein leerer Konstruktur, der das nachträgliche Setzen der Größe erlaubt.
	 */
	public AbstractBox() {}


	/**
	 * Multipliziert die Seitenlängen mit dem als Parameter übergebenen Faktor. 
	 * Lässt das Verhältnis von Höhe zu Breite unverändert.
	 *
	 * @param factor Eine reelle Zahl größer 0.
	 */
	@Override
	public void scale(double factor) {
		width *= factor;
		height *= factor;
	}

	/**
	 * Zeichnet die Box in ein 2D Array.
	 * Muss von abgeleiteten Klassen implementiert werden.
	 *
	 * @param charArray Ein 2D char-Array das exakt der Größe der skalierten Box 
	 *		 entspricht
	 * @param width Die Breite der skalierten Box
	 * @param height Die Höhe der skalierten Box
	 */
	abstract protected void fillArray(char[][] charArray, int width, 
			int height);
	
	/**
	 * Gibt die Box als String aus.
	 *
	 * Delegiert an fillArray.
	 *
	 * @see #fillArray(char[][], int, int)
	 */
	@Override
	public String toString() {
		int tempWidth = getWidth();
		int tempHeight = getHeight();

		char[][] charArray = new char[tempWidth][tempHeight];
		fillArray(charArray, tempWidth, tempHeight);

		String boxString = new String();
		for(int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				boxString += charArray[w][h];
			}
			boxString+= "\n";
		}
		return boxString;
	}

	/**
	 * Liefert die Breite der Box als aufgerundete Ganzzahl. 
	 * Darf nicht Aufgerufen werden, bevor die Breite gesetzt wurde.
	 *
	 * @return Die Breite der Box.
	 */
	protected int getWidth() {
		return (int)Math.ceil(width);
	}

	/**
	 * Liefert die Höhe der Box als aufgerundete Ganzzahl. 
	 * Darf nicht Aufgerufen werden, bevor die Höhe gesetzt wurde.
	 *
	 * @return Die Höhe der Box.
	 */
	protected int getHeight() {
		return (int)Math.ceil(height);
	}

	/**
	 * Bietet die Möglichkeit die Breite im Nachhinein zu setzen. 
	 * Darf nur Verwendet werden, wenn die Breite noch nicht gesetzt wurde. 
	 *
	 * @param width Eine Zahl größer 1.
	 */
	protected void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Bietet die Möglichkeit die Höhe im Nachhinein zu setzen. 
	 * Darf nur Verwendet werden, wenn die Höhe noch nicht gesetzt wurde. 
	 *
	 * @param height Eine Zahl größer 1.
	 */
	protected void setHeight(double height) {
		this.height = height;
	}

   	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;

		if (!(o instanceof AbstractBox)) return false;
		AbstractBox other = (AbstractBox)o;
		return (this.width == other.width) && (this.height == other.height);
	}
}
