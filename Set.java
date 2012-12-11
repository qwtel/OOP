import java.util.Iterator;

/**
 * Eine Instanz von Set stellt eine Menge dar, deren Elementtypen durch einen 
 * Typparameter bestimmt werden. 
 */
@ClassAuthor(who="Florian Klampfer")
public class Set implements Iterable {
	
	/**
	 * Set wird intern durch eine verkettete Liste realisiert.
	 */
	protected Node root;

	/**
	 * Erzeugt ein leeres Set.
	 */
	public Set() {
		root = null;
	}

	/**
	 * Nimmt ein Argument, das in die Menge eingefügt wird.
	 * Wird an der letzten Stelle der Liste eingefügt.
	 * Mehrere gleiche Elemente dürfen in der Menge sein (aber nicht mehrere 
	 * identische).
	 *
	 * @param e Ein Element das in der Liste gespeichert werden soll.
	 * @return false, wenn sich das Element bereits in der Liste befindet.
	 */
	@MethodAuthor(who="Florian Klampfer")
	public boolean insert(Identifiable e) {
		Node newNode = new Node(e);
		if(root == null) {
			root = newNode;
		}
		else {
			Node prev = null;
			Node curr = root;

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

	public Identifiable find(Object id) {
		for(Object o : this) {
			if(o instanceof Identifiable) {
				Identifiable i = (Identifiable)o;
				if(id.equals(i.id())) {
					return i;
				}
			}
		}
		return null;
	}

	/**
	 * Löscht ein Element aus dem Set.
	 * @param toRemove Das Objekt welches aus dem Set gelöscht werden soll.
	 * @return true wenn sich das Objekt im Set befand, ansonsten false.
	 */
	@MethodAuthor(who="Michael Ion")
	public boolean remove(Object id) {
		Iterator iter = iterator();
		Object o;
		while(iter.hasNext()) {
			o = iter.next();
			if(o instanceof Identifiable) {
				Identifiable i = (Identifiable)o;
				if(id.equals(i.id())) {
					iter.remove();
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Liefert als Ergebnis einen Iterator, über den nacheinander auf alle 
	 * Elemente der Menge in nicht weiter bestimmter Reihenfolge zugegriffen 
	 * werden kann. 
	 */
	@Override
	@MethodAuthor(who="Florian Klampfer")
	public Iterator iterator() {
		return new SetIterator();
	}

	/**
	 * Enhält ein Element vom Typ T und verweist auf den nächsten Listenknoten.
	 */
	@ClassAuthor(who="Florian Klampfer")
	protected class Node {
		protected Object key;
		protected Node next;

		/**
		 * Erzeugt einen neuen Knoten welcher zum Einfügen an das Ende einer
		 * Liste geeignet ist.
		 * @param elem Das Element welches in der Liste gespeichert werden soll.
		 */
		protected Node(Object key) {
			this.key = key;
			this.next = null;
		}
	}

	/**
	 * Iteriert über alle Elemente des Sets (in Reihenfolge der Liste).
	 */
	@ClassAuthor(who="Florian Klampfer")
	protected class SetIterator implements Iterator {
		
		private Node node = root;
		private Node prev = null;

		@Override
		@MethodAuthor(who="Florian Klampfer")
		public boolean hasNext() {
			return (node != null);
		}

		@Override
		@MethodAuthor(who="Florian Klampfer")
		public Object next() {
			if(node == null) {
				return null;
			}
			prev = node;
			node = node.next;
			return prev.key;
		}

		/**
		 * Löscht den letzten Node, der von next() geliefert wurde.
		 */
		@Override
		@MethodAuthor(who="Michael Ion")
		public void remove() {
			if(prev == root) {
            	root = root.next;
				return;
			}

			Node temp = root; 
			while(temp.next != prev) {
				temp = temp.next;
			}
			temp.next = prev.next;
		}
	}
}
