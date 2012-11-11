import java.util.Arrays;
import java.util.Scanner;

/**
 * Scaled
 *
 * TODO: Beschreibung
 * 
 * @author TODO
 */
public class Scaled<P extends Pict> extends AbstractPictArray<P> {
	/**
	 * Setzt das Array.
	 *
	 * @param content Ein zweidimensionales, rechteckiges Array.
	 */
	public Scaled(P[][] content) {
		super(content);		
	}

	/**
	 * Jeder Aufruf von scale wird mit demselben Argument direkt an die 
	 * einzelnen Elemente des Arrays weitergeleitet. 
	 */
	@Override
	public void scale(double factor) {
		int width = getContent().length;
		int height = getContent()[0].length;
		for (int h=0; h<height; h++) {
			for(int w=0; w<width; w++) {
				getContent()[w][h].scale(factor);
			}
		}
	}
	
	/**
	 * liefert eine charArray Repräsentation für den toString() Aufruf
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
				String contentString = content[xCounter][yCounter].toString();
				Scanner sc = new Scanner(contentString);
				//Strings aus content[][].toString sind mehrere Zeilen, zeilenweise zum richtigen Platz in charArray
				//dabei Stellen yZeile und xZeile die Stellen innerhalb einer ganzen Zelle dar (also der Platz von einem
				//Aufruf von toString eines Objekts aus Content innerhalb von printArray)
				int yZeile = 0;
				while(sc.hasNextLine()) {
					String temp = sc.nextLine();
					char[] zeile = temp.toCharArray();
					for(int xZeile = 0; xZeile < zeile.length; xZeile++) {
						printArray[w+xZeile][h+yZeile] = zeile[xZeile];
					}
					yZeile++;
				}
				sc.close();
				xCounter++;
			}
			yCounter++;
		}
		return printArray;
	}
	
	public double getFactor() {
		return 1.0;
	}
}
