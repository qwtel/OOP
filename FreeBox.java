import java.util.Scanner;

/**
 * FreeBox
 *
 * TODO: Beschreibung
 * 
 * @author Johannes Deml
 */
public class FreeBox extends AbstractBox {
	private String pattern;
	private char [][] patternArray;

	public FreeBox(String pattern) {
		super();
		this.pattern = pattern;

		calculateSize(pattern);
		
		int width = getWidth();
		int height = getHeight();
		patternArray = new char[width][height];
		patternArray = fillPatternArray(patternArray, width, height);
	}

	private void calculateSize(String pattern) {
		double width = 0;
		double height = 0;
		Scanner scan = new Scanner(pattern);
		boolean firstRun = true;

		if(pattern.isEmpty()) {
			// throw new Exception("Missing String for FreeBox");
		}

		while(scan.hasNextLine()) {
			int count;
			String currentLine = scan.nextLine();
			count = currentLine.length();

			if(firstRun) {
				width = count;
			}
			else if(width != count) {
				// throw new Exception("This is not a rectangle.");
			}

			height++;
		}

		setWidth(width);
		setHeight(height);
	}
	
	private char[][] fillPatternArray(char[][] tempPatternArray, int tempWidth, int tempHeight ) {
		Scanner scan = new Scanner(pattern);
		for(int h=0; h<tempHeight; h++) {
			String currentLine = scan.nextLine();
			for(int w=0; w<tempWidth; w++) {
				tempPatternArray[w][h] = currentLine.charAt(w);
			}
		}
		return patternArray;
	}

	@Override
	public void fillArray(char[][] charArray, int tempWidth, int tempHeight) {
		int originalWidth = patternArray[0].length;
		int originalHeight = patternArray.length;
		for (int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				charArray[w][h]= patternArray[w%originalWidth][h%originalHeight];
			}
		}
	}
}
