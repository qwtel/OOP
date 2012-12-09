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
@Author(who="Florian Klampfer")
public class Set<E> implements Iterable<E> {
	
	/**
	 * Set wird intern durch eine verkettete Liste realisiert.
	 */
	protected Node<E> root;

	/**
	 * Erzeugt ein leeres Set.
	 */
	@Author(who="Florian Klampfer")
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
	@Author(who="Florian Klampfer")
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
				prev = curr;
				curr = prev.next;
			}
			
			prev.next = newNode;
		}
		
		return true;
	}

	/**
	 * TODO: Zusicherungen
	 * XXX: Life is to short to think about pointers (again).
	 */
	@Author(who="Florian Klampfer")
	public boolean remove(E toRemove) {
		Iterator<E> iter = iterator();
		E e;
		while(iter.hasNext()) {
			e = iter.next();

			//if(e.equals(toRemove)) { 
			if(e == toRemove) {
				iter.remove();
				return true
			}
		}
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
	@Author(who="Florian Klampfer")
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
	@Author(who="Florian Klampfer")
	protected class Node<T> {
		protected T key;
		protected Node<T> next;

		/**
		 * Erzeugt einen neuen Knoten welcher zum Einfügen an das Ende einer
		 * Liste geeignet ist.
		 *
		 * @param elem Das Element welches in der Liste gespeichert werden soll.
		 */
		@Author(who="Florian Klampfer")
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
	@Author(who="Florian Klampfer")
	protected class SetIterator<T> implements Iterator<T> {
		
		private final Node<T> root;
		private Node<T> node;
		private Node<T> prev;

		@Author(who="Florian Klampfer")
		public SetIterator(Node<T> node) {
			this.root = node;
			this.node = node;
			this.prev = null;
		}

		@Override
		@Author(who="Florian Klampfer")
		public boolean hasNext() {
			return (node != null);
		}

		@Override
		@Author(who="Florian Klampfer")
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
		 * XXX: What if the root gets deleted?
		 */
		@Override
		@Author(who="Michael Ion")
		public void remove() {
			Node<T> temp = root; 
			while(temp.next != prev) {
				temp = temp.next;
			}
			temp.next = prev.next;
		}
	}
}
