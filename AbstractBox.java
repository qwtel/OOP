/**
 * AbstractBox
 *
 * TODO
 * 
 * @author Johannes Deml, Florian Klampfer
 * @version 1.4
 */
public class AbstractBox implements Pict {
	private double height;
    private double width;

	private char border;
    private char fill;

	public AbstractBox(double width, double height, char border, char fill) {
		this.width = width;
		this.height = height;
		this.border = border;
		this.fill = fill;
	}
	
	/**
	 * preCondition: factor is a number larger than zero
	 * postCondition: ratio has to stay the same
	 */
	@Override
	public void scale(double factor) {
		width *= factor;
		height *= factor;
	}

	/**
	 * HistoryConstraint: FillArray is never after drawBorder
	 * TODO: This is not a history constraint.
	 */

	/**
	 * 
	 * @return charArray with all fields filled with char @param fill
	 */
	private char[][] fillArray(char[][] charArray, int tempWidth,
            int tempHeight, char fill) {

		for(int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				charArray[w][h] = fill;
			}
		}
		return charArray;
	}

	/**
	 * 
	 * @return charArray with a one char-wide border. boderchar is @param border
	 * All other fields are not changed
	 */
	private char[][] drawBorder(char[][] charArray, int tempWidth, 
            int tempHeight, char border) {

		for(int w=0; w<tempWidth; w++) {
			charArray[w][0]= border;
			charArray[w][tempHeight-1]= border;
		}

		for(int h=0; h<tempHeight; h++) {
			charArray[0][h]= border;
			charArray[tempWidth-1][h]= border;

		}
		return charArray;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	public char getBorder() {
		return border;
	}

	public char getFill() {
		return fill;
	}

	/**
	 * rounds up width and height for drawing
	 */
	@Override
	public String toString() {
		int tempWidth = (int) Math.ceil(width);
		int tempHeight = (int) Math.ceil(height);
		char[][] charArray = new char[tempWidth][tempHeight];

		charArray = fillArray(charArray, tempWidth, tempHeight, fill);
		charArray = drawBorder(charArray, tempWidth, tempHeight, border);
		String boxString = new String();

		for(int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				boxString += charArray[w][h];
			}
			boxString+= "\n";
		}
		return boxString;
	}

   	@Override
   	public boolean equals(Object o) {
   		if(o instanceof Box) {
   			if(width == ((Box) o).getWidth()) {
   				if(height == ((Box) o).getHeight()) {
					if(toString().equals(((Box) o).toString())) {
						return true;
					}
   				}
   			}
   		}
   		return false;
   	}
}
