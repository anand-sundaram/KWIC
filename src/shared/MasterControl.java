package shared;

import java.util.StringTokenizer;

public class MasterControl {

	public static String[] wordsToIgnore = {"is", "the", "of", "and", "as", "a", "after"};
	public static String[] titles = {"The Day after Tomorrow", "Fast and Furious", "Man of Steel"};
	public static String[][] titlesByWords;
	
	public static void main(String[] args) {
		
	}
	static void titleSplitter() {
		titlesByWords = new String[titles.length][];
		for (int x = 0; x < titles.length; x++) {
			StringTokenizer str = new StringTokenizer(titles[x]);
			titlesByWords[x] = new String[str.countTokens()];
			for(int y = 0; y < str.countTokens(); y++) {
				titlesByWords[x][y] = str.nextToken();
			}
		}
	}
	static void circularShifter() {
		
	}
	static void alphabetizer() {
		
	}
	static void output() {
		
	}
}
