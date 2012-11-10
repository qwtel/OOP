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
		//alter ansatz, aber unnötig kompliziert: int[][][] lengthIndex = new int[contentHeight][contentWidth][2];
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
				while(scan.hasNextLine()) {
					String temp = scan.nextLine();
					//Maximum Breite aller Zeilen ist gesucht (bei Boxen immer konstant)
					if(lengthx < temp.length())
						lengthx = temp.length();
					//Höhe ist immer Maximum (bei Boxen konstant)
					lengthy++;
				}
				scan.close();
				if(lengthx > maxWidth[w])
					maxWidth[w] = lengthx;
				if(lengthy > maxHeight[h])
					maxHeight[h] = lengthy;
			}
		}
		
		
		
		// TODO
		for(int h=0; h<contentHeight; h++) {
			for(int w=0; w<contentWidth; w++) {
			}
		}
		// TODO
	 	return new String();
	}

	@Override
	public boolean equals(Object o) {
		// TODO
	 	return false;
	}
}
