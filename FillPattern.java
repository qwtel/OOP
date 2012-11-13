/**
 * 
 * Stellt Methoden zur Analyse und Herstellung eines Patterns, sowie die Befüllung
 * mit jenem in ein gegebenes Array bereit
 * @author Michael Ion
 */
public interface FillPattern {
	
	/**
	 * Berechnet die Höhe und Breite des übergebenen Strings
	 * @param pattern die Zeilen im String müssen die gleiche Länge haben
	 */
	void calculateSize(String pattern);
	/**
	 * Überträgt ein Muster zweidimensionales Char-Array
	 * @param tempWidth Breite des Musters
	 * @param tempHeight Höhe des Musters
	 */
	void fillPatternArray(int tempWidth, int tempHeight );
	/**
	 * Befüllt ein Array mit dem Muster (wie eine Textur).
	 * 
	 * @param tempWidth Breite des Arrays (>= 1)
	 * @param tempHeight Höhe  des Arrays (>= 1)
	 */
	void fillArray(char[][] charArray, int tempWidth, int tempHeight);
}
