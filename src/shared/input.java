package shared;

import java.util.Scanner;

public class input {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentences;
		String ignoreWords;
		int architectureType;
		boolean isInvalid = true;
		
		while(isInvalid) {
			scanner = new Scanner(System.in);
			System.out.println("Enter list of sentences:");
			sentences = scanner.nextLine();
			System.out.println("Enter list of words to ignore:");
			ignoreWords = scanner.nextLine();
			System.out.println("Enter choice of architecture 1) Shared Repository 2)Abstract Datatypes (type 1 or 2)");
			
			
			if (scanner.hasNextInt()) {
				architectureType = scanner.nextInt();
				if (architectureType == 1) {
					MasterControl.splitter(sentences, ignoreWords);
					MasterControl.circularShifter();
					MasterControl.alphabetizer();
					MasterControl.output();
					isInvalid = false;
				}
				else if (architectureType == 2) {
					KWIC k = new KWIC(sentences, ignoreWords);
					k.logic();
			        k.print();
			        isInvalid = false;
				}
				else {
					System.out.println("Please enter a valid number (1 or 2)");
				}
			}
			
			else {
				System.out.println("Please enter a number only (1 or 2)");
			}
			
			
		}
		
	}
}
