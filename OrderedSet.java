/**
 * OrderedSet
 *
 * Eine Instanz von OrderedSet stellt eine Menge dar, die wie Set das Interface
 * java.lang.Iterable implementiert. 
 *
 * Ein Typparameter bestimmt den Typ der Elemente. Die Elemente müssen eine 
 * Methode shorter mit einem Parameter unterstützen, die genau dann true 
 * zurückgibt, wenn this (auf nicht näher bestimmte Weise) kürzer als das 
 * übergebene Argument ist. 
 *
 * @param <E> Typ der Elemente welche das Set enthalten soll. Muss das Interface
 *         Shorter für einen Obertyp von E implementieren.
 * @author Michael Ion
 */
public class OrderedSet<E extends Shorter<? super E>> extends Set<E> {

	@Override
	protected boolean insertHere(Node<E> curr, Node<E> newNode) {
    	return (newNode.key.shorter(curr.key));
	}
}
