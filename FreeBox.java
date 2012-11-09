/**
 * FreeBox
 * 
 * @author Florian Klampfer
 */
public class FreeBox extends AbstractBox {
	private String pattern;

	public FreeBox(String pattern) {
		this.pattern = pattern;
		width = calculateWidth(pattern);
		height = calculateHeight(pattern);
	}

	private double calculateWidth(String pattern) {
		return 0.0;
	}

	private double calculateHeight(String pattern) {
		return 0.0;
	}

	private char[][] fillArray(char[][] charArray, int tempWidth,
            int tempHeight, char fill) {
		return charArray;
	}
}
