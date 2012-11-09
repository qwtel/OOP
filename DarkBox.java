/**
 * DarkBox
 * 
 * @author Florian Klampfer
 */
public class DarkBox extends AbstractBox {
	public ClearBox(double width, double height, char fill) {
		super(width, height, fill, fill);
	}

	public double setFill(char fill) {
		this.fill = fill;
		this.border = fill;
	}
}
