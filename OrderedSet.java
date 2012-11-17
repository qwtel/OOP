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

	/**
	 * Nimmt ein Argument, das in die Menge eingefügt wird.
	 *
	 * Wird in der richtigen Stelle in der Liste eingefügt, welche mittels
	 * shorter() bestimmt wird. Die Liste bleibt immer sortiert.
	 *
	 * Mehrere gleiche Elemente dürfen in der Menge sein (aber nicht mehrere 
	 * identische).
	 *
	 * @param e Ein Element das sich noch nicht im Set befindet.
	 * @return false, wenn sich das Element bereits in der Liste befindet.
	 */
	@Override
	public boolean insert(E e) {
		Node<E> newNode = new Node<E>(e);
		if(root == null) {
			root = newNode;
		}
		else {
			Node<E> prev = null;
			Node<E> curr = root;			
			while(curr != null) {
				if(curr == newNode) {
					return false;
				}
				else if(newNode.elem.shorter(curr.elem)) {
					if(prev != null) {
						prev.next = newNode;
					}
					else {
						root = newNode;
					}
					newNode.next = curr;
					return true;
				}
			
				prev = curr;
				curr = prev.next;
			}
			prev.next = newNode;
		}
		return true;
		
	}
}
