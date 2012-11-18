import java.util.Iterator;



/**
 * OrderedMap
 *
 * OrderedMap unterscheidet sich von OrderedSet nur dadurch, dass jedes Element
 * der Menge auf weitere Objekte verweisen kann. 
 *
 * OrderedMap hat 2 Listen. In einer sind die Keys in Form
 * von Nodes allein gespeichert (wird von OrderedSet übernommen), in der
 * anderen sind Sowohl die Keys als auch die Nodes gespeichert. So muss ein
 * Node nicht unbedingt mit einem Set zusammenhängen
 * 
 *
 * @param <E> Typ der Elemente die den Key für die Map bilden dürfen. 
 * 			  Nach E wird die Map auch sortiert.
 * @param <F> Typ der Elemente die im ValueSet gespeichert werden. Muss nicht
 * 			  über shorten vergleichbar sein.
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
	/**
	 * Speichert sowohl den Key als auch das ValueSet. MapNode bildet die
	 * Grundlage für die Speicherung der verketteten Liste der Map.
	 *
	 * @param <K> Ist immer vom Parametertyp E und wird für den Key genutzt
	 * @param <V> Ist immer vom Parametertyp F und wird für die values genutzt
	 */
	private class MapNode<K,V>{
		private K key;
		private Set<V> value;
		private MapNode<K, V> next = null;
		
		MapNode(K key, Set<V> value) {
			this.key = key;
			this.value = value;
		}
	}
	
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
}
