import java.util.Scanner;
/**
 * FreeBox
 * 
 * @author Florian Klampfer
 */
public class FreeBox extends AbstractBox {
	private String pattern;
	private double width = 0;
	private double height = 0;
	private char [][] patternArray;
	public FreeBox(String pattern) {
		this.pattern = pattern;
		calculateSize(pattern);
		patternArray = new char[(int) width][(int) height];
		patternArray = fillPatternArray(patternArray, (int) width, (int) height);
		}

	private void calculateSize(String pattern) throws Exception {
		Scanner scan = new Scanner(pattern);
		boolean firstRun = true;
		if(pattern.isEmpty()) {
			throw new Exception("Missing String for FreeBox");
		}
		while(scan.hasNextLine()) {
			int count;
			String currentLine = scan.nextLine();
			count = currentLine.length();
			if(firstRun) {
				width = count;
			} else if(width != count) {
				throw new Exception("This is not a rectangle.");
			}
			height++;
		}
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

	private char[][] fillArray(char[][] charArray, int tempWidth,
            int tempHeight, char fill) {
		int originalWidth = patternArray[0].length;
		int originalHeight = patternArray.length;
		for (int h=0; h<tempHeight; h++) {
			for(int w=0; w<tempWidth; w++) {
				charArray[w][h]= patternArray[w%originalWidth][h%originalHeight];
			}
		}
		return charArray;
	}
}
