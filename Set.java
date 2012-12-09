import java.util.Iterator;

/**
 * Set
 *
 * Eine Instanz von Set stellt eine Menge dar, deren Elementtypen durch einen 
 * Typparameter bestimmt werden. 
 * 
 * @param <E> Typ der Elemente welche das Set enthalten soll.
 * @author Michael Ion, Florian Klampfer
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
			Node<E> prev = null;
			Node<E> curr = root;

			while(curr != null) {
				if(curr.key == e) {
			return false;
				}
				else if(insertHere(curr, newNode)) {
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
			
			// deal with special cases here
			prev.next = newNode;
		}
		
		return true;
	}
	
	/**
	 * Entscheidet ob ein Knoten an der Stelle (curr) in die Liste eingefügt
	 * wird. 
	 *
	 * @param curr Der aktuelle Knoten der Listen-Schleife.
	 * @param newNode Der einzufügende Knoten.
	 */
	protected boolean insertHere(Node<E> curr, Node<E> newNode) {
		return false;
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
		return new SetIterator<E>(root);
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
		protected T key;
		protected Node<T> next;

		/**
		 * Erzeugt einen neuen Knoten welcher zum Einfügen an das Ende einer
		 * Liste geeignet ist.
		 *
		 * @param elem Das Element welches in der Liste gespeichert werden soll.
		 */
		protected Node(T key) {
			this.key = key;
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
	protected class SetIterator<T> implements Iterator<T> {
		
		private final Node<T> root;
		private Node<T> node;
		private Node<T> prev;

		public SetIterator(Node<T> node) {
			this.root = node;
			this.node = node;
			this.prev = null;
		}

		@Override
		public boolean hasNext() {
			return (node != null);
		}

		@Override
		public T next() {
			if(node == null) {
				return null;
			}
			prev = node;
			node = node.next;
			return prev.key;
		}

		/**
		 * Löscht den letzten Node, der von next() geliefert wurde
		 */
		@Override
		public void remove() {
			Node<T> temp = root; 
			while(temp.next != prev) {
				temp = temp.next;
			}
			temp.next = prev.next;
		}
	}
}
