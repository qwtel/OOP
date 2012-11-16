/**
 * Shorter
 *
 * Beschreibt nur die Methode shorter (wie in OrderedSet und OrderedMap 
 * gefordert).
 *
 * @param <T> Typ des Elements dessen Länge verglichen werden soll.
 * @author Florian Klampfer
 */
public interface Shorter<T> {

 	/**
	 * Gibt genau dann true zurück, wenn this (auf nicht näher bestimmte Weise) 
	 * kürzer als das übergebene Argument ist.
	 *
	 * @param other Das zu vergleichende Element.
	 * @return true, wenn this kürzer als other ist.
	 */
	public boolean shorter(T other);
}
