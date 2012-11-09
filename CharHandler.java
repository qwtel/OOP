/**
 * CharHandler
 * 
 * Handles whether chars are allowed or not for Boxes
 * 
 * @author Johannes Deml
 * @version 1.4
 */
public class CharHandler {
	private char[] definedChars;
	private boolean isRestricted = false;
	
	public CharHandler(boolean isRestricted, char[] definedCahrs) {
		this.isRestricted = isRestricted;
		this.definedChars = definedCahrs;
	}
	
	public boolean validChar(char toCheck) {
		boolean inArray = false;
		for(int i = 0; i<definedChars.length; i++) {
			if(definedChars[i] == toCheck) {
				inArray = true;
			}
		}
		return isRestricted^inArray;
	}
}

