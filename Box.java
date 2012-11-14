/**
 * Box
 *
 * Instanzen von Box stellen aus druckbaren Zeichen geformte Rechtecke dar.
 *
 * Die beiden zu verwendenden Zeichen werden im Konstruktor gesetzt und bleiben
 * danach unverändert. (history constraint)
 *
 * Die Ränder einer Box können aus anderen Zeichen bestehen als der 
 * Inhalt, allerdings nicht aus Leerzeichen.
 *
 * Höhe und Breite (jeweils als Anzahl der Zeichen angegeben) stehen in einem 
 * fixen Verhältnis zueinander. 
 *
 * @author Florian Klampfer
 */
public class Box extends ClassicBox {

	/**
	 * Erzeugt eine Box.
	 *
	 * Als Zeichen für die Ränder ist kein Leerzeichen erlaubt, für den Inhalt 
	 * schon. 
	 *
	 * @param width Eine Zahl größer 1.
	 * @param height Eine Zahl größer 1.
	 * @param border Ein druckbarers Zeichen, aber nicht das Leerzeichen. 
	 * @param fill Ein druckbares Zeichen.
	 */
	public Box(double width, double height, char border, char fill) {
		super(width, height, border, fill);
		// NOTE: Einschränkung auf border durch Zusicherung
	}
}
