import java.util.Scanner;

/**
 * FreeBox
 *
 * FreeBox repräsentiert eine rechteckige Box mit einem Muster.
 * 
 * FreeBox hat eine Höhe, eine Breite und ein Muster. Teilweise erbt es von
 * AbstractBox Methoden.
 * 
 * Der String den FreeBox enthält, muss genau gleichlange Zeilen haben
 * 
 * @author Johannes Deml
 */
public class FreeBox extends AbstractBox {
	private String pattern;
	private char [][] patternArray;
	/**
	 * 
	 * @param pattern Die Zeilen in dem String müssen die gleiche Länge haben
	 * da ansonsten kein Rechteck gegeben ist
	 */
	public FreeBox(String pattern) {
		super();
		this.pattern = pattern;

		calculateSize(pattern);
		
		int width = getWidth();
		int height = getHeight();
		patternArray = new char[width][height];
		fillPatternArray(width, height);
	}
	
	/**
	 * Wird nur einmal vom Konstruktor aufgerufen, dienst zum extrahieren
	 * der Informationen die im String gespeichert sind. Es findet die Höhe und 
	 * Breite heraus
	 * @param pattern Die Zeilen im String müssen die gleiche Länge haben
	 */
	private void calculateSize(String pattern) {
		double width = 0;
		double height = 0;
		Scanner scan = new Scanner(pattern);
		while(scan.hasNextLine()) {
			int count;
			String currentLine = scan.nextLine();
			count = currentLine.length();
			width = count;
			height++;
		}
		scan.close();
		setWidth(width);
		setHeight(height);
	}
	
	/**
	 * Füllt das Pattern (String) in ein zweidimensionales Char-Array
	 * @param tempWidth Breite des Patterns
	 * @param tempHeight Höhe des Patterns
	 */
	private void fillPatternArray(int tempWidth, int tempHeight ) {
		Scanner scan = new Scanner(pattern);
		for(int h=0; h<tempHeight; h++) {
			String currentLine = scan.nextLine();
			for(int w=0; w<tempWidth; w++) {
				patternArray[w][h] = currentLine.charAt(w);
			}
		}
		scan.close();
	}
	
	/**
	 * Erzeugt einen String der Repetiv mit dem Pattern gefüllt wird
	 * 
	 * @param tempWidth Breite der Freebox, muss größer oder gleich 1 sein
	 * @param tempHeight Höhe der FreeBox, muss größer oder gleich 1 sein
	 */
	@Override
	public void fillArray(char[][] charArray, int tempWidth, int tempHeight) {
		int originalWidth = patternArray.length;
		int originalHeight = patternArray[0].length;
		for (int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				charArray[w][h]= patternArray[w%originalWidth][h%originalHeight];
			}
		}
	}
	

   	@Override
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;

		if (!(o instanceof FreeBox)) return false;
		FreeBox other = (FreeBox)o;
		return pattern.equals(other.pattern);
	}
}
