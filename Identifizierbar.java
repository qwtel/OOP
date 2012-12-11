/**
 * Ein Objekt welches über eine id() verfügt.
 */
@ClassAuthor(who="Florian Klampfer")
public interface Identifizierbar {

	/**
	 * @return Ein "Objekt" welches das Element (in einem Set) identifiziert.
	 *         Üblicherweise ein Integer oder String.
	 */
	@MethodAuthor(who="Florian Klampfer")
	public Object id();
}
