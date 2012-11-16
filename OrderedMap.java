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
 * @author TODO
 */
public class OrderedMap<E extends Shorter<? super E>, 
	   F extends Shorter<? super F>> extends OrderedSet<E> {

	/**
	 * Iterator entspricht im Wesentlichen der gleichnamigen Methode in 
	 * OrderedSet. 
	 *
	 * Der zurückgegebene Iterator hat jedoch (neben hasNext, next und remove) 
	 * ebenfalls eine Methode iterator, die einen Iterator über den Objekten 
	 * zurückgibt, auf welche das aktuelle Element verweist. Der zuletzt 
	 * genannte Iterator gibt die Objekte in der beim Einfügen bestimmten 
	 * Reihenfolge zurück. 
	 *
	 * Neben hasNext und next unterstützt er auch die Methoden remove zum 
	 * Löschen des zuletzt zurückgegebenen Elements sowie add zum Einfügen eines
	 * neuen Elements an der aktuellen Position. Diese Methoden entsprechen 
	 * jenen in der API-Spezifikation von java.util.ListIterator (jedoch ohne 
	 * weitere Methoden wie previous, set, etc.).
	 */
	@Override
	public Iterator<E> iterator() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * TODO
	 */
 	private class OrderedMapIterator implements Iterable<E>, ListIterator<E> {

		@Override
		public Iterator<E> iterator() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
		@Override
		public boolean hasNext() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public E next() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		/*
		 * XXX: No need to implement the following methods:
		 */
		@Override
		public boolean hasPrevious() {
			throw new UnsupportedOperationException("Not supported yet.");
		}

		@Override
		public E previous() {
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
		public void set(E e) {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}
}
