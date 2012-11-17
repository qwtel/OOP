import java.util.Iterator;

/**
 * Set
 *
 * Eine Instanz von Set stellt eine Menge dar, deren Elementtypen durch einen 
 * Typparameter bestimmt werden. 
 * 
 * @param <E> Typ der Elemente welche das Set enthalten soll.
 * @author Florian Klampfer
 */
public class Set<E> implements Iterable<E> {
	
	/**
	 * Set wird intern durch eine verkettete Liste realisiert.
	 */
	protected Node<E> root;

	/**
	 * Erzeugt ein leeres Set.
	 */
	public Set() {
		root = null;
	}

	/**
	 * Nimmt ein Argument, das in die Menge eingefügt wird.
	 *
	 * Wird an der letzten Stelle der Liste eingefügt.
	 *
	 * Mehrere gleiche Elemente dürfen in der Menge sein (aber nicht mehrere 
	 * identische).
	 *
	 * @param e Ein Element das in der Liste gespeichert werden soll.
	 * @return false, wenn sich das Element bereits in der Liste befindet.
	 */
	public boolean insert(E e) {
		Node<E> newNode = new Node<E>(e);
		if(root == null) {
			root = newNode;
		}
		else {
			Node<E> node = root;
			Node<E> prev = null;

			while(loopCondition(node, prev, newNode)) {
				if(node.elem == e) {
                	return false;
				}
				prev = node;
				node = node.next;
			}
			
			// deal with special cases here
			prev.next = newNode;
		}
		
		return true;
	}
	
	/**
	 * Gibt true zurück wenn das Set leer ist, sonst false
	 */
	public boolean isEmpty() {
		return (root == null) ? true : false;
	}
	
	/**
	 * XXX: Override this method in OrderedSet
	 */
	protected boolean loopCondition(Node<E> node, Node<E> prev, Node<E> newNode)
	{
		return (node != null);
	}

	/**
	 * Liefert als Ergebnis einen Iterator, über den nacheinander auf alle 
	 * Elemente der Menge in nicht weiter bestimmter Reihenfolge zugegriffen 
	 * werden kann. 
	 *
	 * Der Iterator muss auch remove implementieren und darf keine 
	 * UnsupportedOperationException werfen (siehe java.lang.Iterator).
	 */
	@Override
	public Iterator<E> iterator() {
		return new SetIterator();
	}

	/**
	 * Node
	 *
	 * Enhält ein Element vom Typ T und verweist auf den nächsten Listenknoten.
	 *
	 * @param <T> Typ des Elements welcher von Node gekapselt wird.
	 * @author Florian Klampfer
	 */
	protected class Node<T> {
		protected T elem;
		protected Node next;

		/**
		 * Erzeugt einen neuen Knoten welcher zum Einfügen an das Ende einer
		 * Liste geeignet ist.
		 *
		 * @param elem Das Element welches in der Liste gespeichert werden soll.
		 */
		protected Node(T elem) {
			this.elem = elem;
			this.next = null;
		}
	}

	/**
	 * SetIterator
	 *
	 * Iteriert über alle Elemente des Sets (in Reihenfolge der Liste).
	 *
	 * @author Florian Klampfer
	 */
 	private class SetIterator implements Iterator<E> {
		private Node<E> node = root;
		private Node<E> prev = null;

		@Override
		public boolean hasNext() {
			return (node != null);
		}

		@Override
		public E next() {
			if(node == null) {
				return null;
			}
			prev = node;
			node = node.next;
			return prev.elem;
		}

		/**
		 * XXX: this is probably not working correctly.
		 */
		@Override
		public void remove() {
			prev.next = node.next;
		}
	}
}
