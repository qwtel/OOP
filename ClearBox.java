/**
 * ClearBox
 * 
 * @author Mihi
 * @version 0.1
 */
public class ClearBox extends AbstractBox {
	private double ratio;
	public ClearBox(double width, double height){
		super(width, height, '*', ' ' );
		ratio = width/height;
	}

	public double getRatio() {
		return ratio;
	}
}
