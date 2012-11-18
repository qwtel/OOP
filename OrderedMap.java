import java.util.Iterator;
import java.util.ListIterator;


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
public class OrderedMap<E extends Shorter<? super E>, 
	   F extends Shorter<? super F>> extends OrderedSet<E> {
	
	private class MapNode<K,V>{
		private K key;
		private Set<V> value;
		private MapNode<K,V> next = null;
		MapNode(K key, Set<V> value) {
			this.key = key;
			this.value = value;
		}
	}
	
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
				previousMapNode = currentMapNode;
				currentMapNode = currentMapNode.next;
			}
			
			previousMapNode.next = newNode;
		}
		
		return true;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new OrderedMapIterator();
	}
	/**
	 * TODO
	 */
 	private class OrderedMapIterator extends SetIterator implements Iterator<E> {
 		private MapNode<E, F> currentMapNode = rootMapNode;
 		private MapNode<E, F> previousMapNode = null;
 		boolean hasSet = false;
		@Override
		public E next() {
			E node = super.next();
			if(currentMapNode.key == node) {
				if(!(currentMapNode == null)) {
				previousMapNode = currentMapNode;
				currentMapNode = currentMapNode.next;
				hasSet = true;
				}
				
			} else {
				hasSet = false;
			}
			return node;
		}

		@Override
		public void remove() {
			super.remove();
			if(hasSet) {
				MapNode<E,F> temp = rootMapNode;
				while(temp.next != previousMapNode) {
					temp = temp.next;
				}
				temp.next = previousMapNode.next;
			}
		}
		
		public Iterator<F> iterator() {
			if(hasSet) {
				return currentMapNode.value.iterator();
			}
			return null;
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
