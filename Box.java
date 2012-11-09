/**
 * Box
 * 
 * @author Johannes Deml
 * @version 1.4
 */
public class Box extends AbstractBox {
	public Box(double width, double height, char border, char fill) 
			throws Exception {
		
		super(width, height, border, fill);
		
        // TODO
	    if(fill == ' ') {
            throw new Exception("Fuuuu");
	    }
	}
}
