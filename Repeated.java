import java.util.Arrays;
import java.util.Scanner;

/**
 * Repeated
 *
 * Speichert Objekte in ein Array und
 * erweitert bei Bedarf die toString() Aufrufe
 * mit dem scale factor
 * 
 * @author Michael Ion
 */
public class Repeated<P> extends AbstractPictArray<P> implements FillPattern{
	private double factor;
	private int width;
	private int height;
	private char pattern[][];
	private String inhalt;
	/**
	 * Setzt das Array und bestimmt den initialen Skalierungsfaktor.
	 *
	 * @param content Ein zweidimensionales, rechteckiges Array.
	 */
	public Repeated(P[][] content) {
		super(content);		
		factor = 1.0;
		width = 0;
		height = 0;
		pattern = new char[width][height];
		inhalt = "";
	}

	/**
	 * Ändert die Größe, ohne jedoch das Array zu verändern.
	 *
	 * @param factor Eine reelle Zahl größer 0.
	 */
	@Override
	public void scale(double factor) {
		this.factor *= factor;
	}
	
	public double getFactor() {
		return factor;
	}
	
	public void calculateSize(String pattern) {
		Scanner sc = new Scanner(pattern);
		//Strings aus content[][].toString sind mehrere Zeilen, zeilenweise zum richtigen Platz in charArray
		//dabei stellen yZeile und xZeile die Stellen innerhalb einer ganzen Zelle dar (also der Platz von einem
		//Aufruf von toString eines Objekts aus Content innerhalb von printArray)
		//Zuerst Anzahl der Zeilen herausfinden:
		int zeilenZahl = 0;
		int spaltenZahl = 0;
		while(sc.hasNextLine()) {
			spaltenZahl = sc.nextLine().length();
			zeilenZahl++;
		}
		sc.close();
		height = zeilenZahl;
		width = spaltenZahl;
	}
	
	
	public void fillPatternArray(int tempWidth, int tempHeight ) {
		pattern = new char[tempWidth][tempHeight];
		Scanner sc = new Scanner(inhalt);
		for(int y = 0; sc.hasNextLine(); y++) {
			String temp = sc.nextLine();
			for(int x = 0; x < temp.length(); x++) {
				pattern[x][y] = temp.charAt(x);
			}
		}
		sc.close();
	}
	
	public void fillArray(char[][] charArray, int tempWidth, int tempHeight) {
		int heightScaled = (int) Math.ceil(height*factor);
		int widthScaled = (int) Math.ceil(width*factor);
		for(int y = 0; y < heightScaled; y++) {
			for(int x = 0; x < widthScaled; x++) {
				charArray[tempWidth+x][tempHeight+y] = pattern[x%(width)][y%(height)];
			}
		}
	}
	

	/**
	 * liefert eine charArray Repräsentation für den toString() Aufruf; Scale erweitert die Zellen mit dem Inhalt als Textur
	 */
	public char[][] getPrintArray(int[] maxWidth, int[] maxHeight) {
		P[][] content = getContent();
		//die Maße des charArrays sind die Summen aller gespeicherten Breiten bzw. Höhen
		int sumHeight = getSumLength(maxHeight);
		int sumWidth = getSumLength(maxWidth);
		char[][] printArray = new char[sumWidth][sumHeight];
		for(int i = 0; i< sumWidth; i++) {
			Arrays.fill(printArray[i], ' ');
		}
		//das printArray wird mit den Ergebnissen der toString()-Aufrufe befüllt
		//Schrittweite ist dabei immer die Höhe bzw. Breite der einzelnen Zelle;
		//x- und yCounter sind schrittweise Inkrementierungen, wir brauchen sie um content
		//abzutasten und die richtige Höhe aus maxHeight und maxWidth abzulesen
		int yCounter = 0;
		for(int h = 0; h < sumHeight; h += maxHeight[yCounter-1]) {
			int xCounter = 0;
			for(int w = 0; w < sumWidth; w += maxWidth[xCounter-1]) {
				//Objekt aus content in einen String
				inhalt = content[xCounter][yCounter].toString();
				//Größe des Inhalts bestimmen
				calculateSize(inhalt);

				
				//Pattern in ein Array speichern
				fillPatternArray(width, height);
				
				//jetzt wird das Pattern übertragen und wenn nötig skaliert
				fillArray(printArray, w, h);
				
				xCounter++;
			}
			yCounter++;
		}
		return printArray;
	}
}
