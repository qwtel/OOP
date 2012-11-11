import java.util.Arrays;
import java.util.Scanner;

/**
 * AbstractPictArray
 *
 * TODO: Beschreibung
 * 
 * @author mihi
 */
public abstract class AbstractPictArray<P> implements Pict {
	private final P[][] content;

	/**
	 * Setzt das Array.
	 *
	 * @param content Ein nichtleeres, zweidimensionales, rechteckiges Array.
	 */
	public AbstractPictArray(P[][] content) {
		this.content = content;			
	}
	
	@Override
	abstract public void scale(double factor);
	
	/**
	 * Gibt den Inhalt zurück.
	 */
	protected P[][] getContent() {
		return content;
	}
	
	
	/**
	 * Gibt die Elemente des Arrays nebeneinander und übereinander liegend 
	 * zurück. (genauer gesagt die Ergebnisse der Aufrufe von toString in den 
	 * Elementen). 
	 *
	 * Haben die Elemente unterschiedliche Höhe bzw. Breite, werden die 
	 * kleineren Elemente unterhalb bzw. rechts mit Leerzeichen aufgefüllt.
	 */
	
	@Override
	public String toString() {
		int contentHeight = content[0].length;
		int contentWidth = content.length;
		int[] maxHeight = new int[contentHeight];
		int[] maxWidth = new int[contentWidth];
		Arrays.fill(maxHeight, 0);
		Arrays.fill(maxWidth, 0);
		//Bestimmung und Speicherung der Länge/Breite jedes einzelnen Objekts
		//toString() in jeder Zelle, durch Scanner werden Höhe und Breite ermittelt
		//wir brauchen in jeder Zeile die maximale Höhe, in jeder Spalte die maximale Breite (Speicherung in maxWidth und maxHeight)
		for(int h=0; h<contentHeight; h++) {
			for(int w=0; w<contentWidth; w++) {
				int lengthx = 0;
				int lengthy = 0;
				String contentString = content[w][h].toString();
				Scanner scan = new Scanner(contentString);
				//Berechnung der Maße
				while(scan.hasNextLine()) {
					String temp = scan.nextLine();
					//Maximum Breite aller Zeilen ist gesucht (bei Boxen immer konstant)
					if(lengthx < temp.length())
						lengthx = temp.length();
					//Höhe ist immer Maximum (bei Boxen konstant)
					lengthy++;
				}
				scan.close();
				//um den entsprechenden Faktor sind die Felder zu erweitern
				if(lengthx > maxWidth[w])
					maxWidth[w] = (int) Math.ceil(lengthx*getFactor());
				if(lengthy > maxHeight[h])
					maxHeight[h] = (int) Math.ceil(lengthy*getFactor());
			}
		}
		/* printArray ist ein massives charArray mit allen Zeichen 
		 * der gesamten Ausgabe, wird jetzt nacheinander in einen String umgewandelt
		 */
		char[][] printArray = getPrintArray(maxWidth, maxHeight);
		
		String ausgabe = "";
		for(int h = 0; h < printArray[0].length; h++) {
			for(int w = 0; w < printArray.length; w++) {
				ausgabe = ausgabe + "" + printArray[w][h];
			}
			if(h != printArray[0].length -1)
				ausgabe += "\n";
		}
	 	return ausgabe;
	}
	/**
	 * @return die Gesamtlänge (also die Summe aller gespeicherten Werte) zurück
	 */
	public int getSumLength(int[] lengthArray) {
		int sum = 0;
		for(int i=0; i< lengthArray.length; i++) {
			sum += lengthArray[i];
		}
		return sum;
	}
	
	/**
	 * @return der Skalierungsfaktor
	 */
	public abstract double getFactor();
	
	/**
	 * liefert die finale druckfähige Version des Inhalts als char array
	 * @param maxWidth die einheitliche Breiten für jede Spalte 
	 * @param maxHeight die einheitlichen Höhen für jede Zeile
	 * @return char array für den toString() Aufruf
	 */
	public abstract char[][] getPrintArray(int[] maxWidth, int[] maxHeight);

	@Override
	public boolean equals(Object o) {
		// TODO
	 	return false;
	}
}
