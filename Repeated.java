import java.util.Arrays;
import java.util.Scanner;

/**
 * Repeated
 *
 * TODO: Beschreibung
 * 
 * @author TODO
 */
public class Repeated<P> extends AbstractPictArray<P> {
	private double factor;

	/**
	 * Setzt das Array und bestimmt den initialen Skalierungsfaktor.
	 *
	 * @param content Ein zweidimensionales, rechteckiges Array.
	 */
	public Repeated(P[][] content) {
		super(content);		
		factor = 1.0;
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
				String contentString = content[xCounter][yCounter].toString();
				Scanner sc = new Scanner(contentString);
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
				int zeilenZahlSkaliert = (int) Math.ceil(zeilenZahl*factor);
				int spaltenZahlSkaliert = (int) Math.ceil(spaltenZahl*factor);
				sc.close();
				
				//Pattern in ein Array speichern
				char[][] pattern = new char[spaltenZahl][zeilenZahl];
				sc = new Scanner(contentString);
				
				for(int y = 0; sc.hasNextLine(); y++) {
					String temp = sc.nextLine();
					for(int x = 0; x < temp.length(); x++) {
						pattern[x][y] = temp.charAt(x);
					}
				}
				sc.close();
				
				//jetzt wird das Pattern übertragen und wenn nötig skaliert
				for(int y = 0; y < zeilenZahlSkaliert; y++) {
					for(int x = 0; x < spaltenZahlSkaliert; x++) {
						printArray[w+x][h+y] = pattern[x%(spaltenZahl)][y%(zeilenZahl)];
					}
				}
				xCounter++;
			}
			yCounter++;
		}
		return printArray;
	}
	
	/*
	
	 * TODO 
	 *
	 * Ist der durch (wiederholte) Aufrufe von scale gesetzte Skalierungsfaktor 
	 * kleiner 1.0, so liefert toString nur die entsprechend große linke obere 
	 * Ecke. Ist der Skalierungsfaktor größer als 1.0, so wird der Text 
	 * entsprechend oft neben- bzw. übereinander wiederholt.
	 
	@Override
	public String toString() {
		// TODO
	 	return new String();
	}
	
	*/
}
