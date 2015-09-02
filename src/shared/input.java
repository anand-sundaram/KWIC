package shared;

import java.util.Scanner;

public class input {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentences;
		String ignoreWords;
		int architectureType;
		
		System.out.println("Enter list of sentences:");
		sentences = scanner.nextLine();
		System.out.println("Enter list of words to ignore:");
		ignoreWords = scanner.nextLine();
		System.out.println("Enter choice of architecture 1) Shared Repository 2)Abstract Datatypes (type 1 or 2)");
		architectureType = scanner.nextInt();
		
		if (architectureType == 1) {
			MasterControl.splitter(sentences, ignoreWords);
			MasterControl.circularShifter();
			MasterControl.alphabetizer();
			MasterControl.output();
		}
		else {
			KWIC k = new KWIC(sentences, ignoreWords);
			k.logic();
	        k.print();
		}
		
	}
}
