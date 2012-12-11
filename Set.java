import java.util.Iterator;

/**
 * Eine Instanz von Set stellt eine Menge da.
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
	 * Nimmt ein Identifiable, das in die Menge eingefügt wird.
	 * Wird an der letzten Stelle der Liste eingefügt.
	 *
	 * @param e Ein Identifiable das in der Liste gespeichert werden soll. 
	 *          Darf noch nicht enhalten sein oder die gleiche id() wie ein 
	 *          bereits vorhandenes Identifiable besitzen.
	 */
	@MethodAuthor(who="Florian Klampfer")
	public void insert(Identifizierbar e) {
		Node newNode = new Node(e);
		if(root == null) {
			root = newNode;
		}
		else {
			Node prev = null;
			Node curr = root;
			while(curr != null) {
				prev = curr;
				curr = prev.next;
			}
			prev.next = newNode;
		}
	}

	/**
	 * Findet ein Identifiable im Set basierend auf dessen id().
	 * @param id Die id() des gesuchten Elements.
	 * @return false wenn das Objekt sich nicht im Set befindet. 
	 */
	@MethodAuthor(who="Florian Klampfer")
	public Identifizierbar find(Object id) {
		for(Object o : this) {
			if(o instanceof Identifizierbar) {
				Identifizierbar i = (Identifizierbar)o;
				if(id.equals(i.id())) {
					return i;
				}
			}
		}
		return null;
	}

	/**
	 * Löscht ein Identifiable aus dem Set.
	 * @param id Die id() des Elements welches aus dem Set gelöscht werden soll.
	 * @return true wenn das Objekt entfernt wurde, ansonsten false.
	 */
	@MethodAuthor(who="Michael Ion")
	public boolean remove(Object id) {
		Iterator iter = iterator();
		Object o;
		while(iter.hasNext()) {
			o = iter.next();
			if(o instanceof Identifizierbar) {
				Identifizierbar i = (Identifizierbar)o;
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
	 * Elemente der Menge zugegriffen werden kann. 
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
		 * @param key Das Element welches in der Liste gespeichert werden soll.
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
