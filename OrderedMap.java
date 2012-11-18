import java.util.Iterator;



/**
 * OrderedMap
 *
 * OrderedMap unterscheidet sich von OrderedSet nur dadurch, dass jedes Element
 * der Menge auf weitere Objekte verweisen kann. 
 *
 * Der Typ dieser Objekte wird durch einen weiteren Typparameter bestimmt.
 * 
 * XXX: I have no idea what this is supposed to do o_O
 *
 * @param <E> ???
 * @param <F> ???
 * @author Johannes Deml
 */
public class OrderedMap<E extends Shorter<? super E>, F> extends OrderedSet<E> {
	
	private MapNode<E,F> rootMapNode;
	
	public OrderedMap () {
		super();
		rootMapNode = null;
	}
	
	public boolean insert(E key, Set<F> value) {
		if(! super.insert(key)) {
			return false;
		}
		MapNode<E,F> newNode = new MapNode<E,F>(key, value);
		if(rootMapNode == null) {
			rootMapNode = newNode;
		} else {
			
			MapNode<E,F> currentMapNode = rootMapNode;
			MapNode<E,F> previousMapNode = null;
			
			while(currentMapNode != null) {
				if(currentMapNode.key == newNode.key) {
					return false;
				}
				if(newNode.key.shorter(currentMapNode.key)) {
					if(previousMapNode != null) {
						previousMapNode.next = newNode;
					} else {
						rootMapNode = newNode;
					}
					newNode.next = currentMapNode;
					return true;
				}
				
				previousMapNode = currentMapNode;
				currentMapNode = currentMapNode.next;
			}
			
			previousMapNode.next = newNode;
		}
		return true;		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new OrderedMapIterator<E, F>(root, rootMapNode);
	}
		
	private class MapNode<K,V>{
		private K key;
		private Set<V> value;
		private MapNode<K, V> next = null;
		
		MapNode(K key, Set<V> value) {
			this.key = key;
			this.value = value;
		}
	}
	
	/**
	 * TODO
	 */
 	private class OrderedMapIterator<K, V> extends SetIterator<K> 
			implements Iterable<V> {

		private final MapNode<K, V> rootMapNode;
 		private MapNode<K, V> currentMapNode;
 		private MapNode<K, V> previousMapNode;
 		boolean hasSet = false;
		
		public OrderedMapIterator(Node<K> root, MapNode<K, V> rootMapNode) {
			super(root);
			this.rootMapNode = rootMapNode;
			this.currentMapNode = rootMapNode;
			this.previousMapNode = null;
		}

		@Override
		public K next() {
			K receivedNode = super.next();
			if(currentMapNode.key == receivedNode) {
				if(!(currentMapNode == null)) {
					previousMapNode = currentMapNode;
					currentMapNode = currentMapNode.next;
					hasSet = true;
				}
				
			} else {
				hasSet = false;
			}
			return receivedNode;
		}

		@Override
		public void remove() {
			super.remove();
			if(hasSet) {
				MapNode<K, V> temp = rootMapNode;
				while(temp.next != previousMapNode) {
					temp = temp.next;
				}
				temp.next = previousMapNode.next;
			}
		}
		
		@Override
		public Iterator<V> iterator() {
			if(hasSet) {
				return previousMapNode.value.iterator();
			}
			return new SetIterator<V>(null);
		}
 	}


 	// TODO add für Set hinzufügen
/* 	private class OrderedMapSetIterator implements ListIterator<F> {

 		@Override
		public void add(F e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public F next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
		 * XXX: No need to implement the following methods:
		 
 		@Override
		public boolean hasPrevious() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public F previous() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public void set(F e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}*/
}
