/*
 * Implementation of KWIC using "Data abstraction 
 * and Object-Oriented Organisation" design style
 */

import java.util.Scanner;

public class KWIC 
{
	String [] sentence;
	String [] wordsToIgnore;
	
	KWIC(String sentences, String ignoreWords)
	{
		sentence = sentences.split(",");
		wordsToIgnore = ignoreWords.split(",");
	}
	
	public void print()
	{
		int i = 0, j = 0;
		while(j < sentence.length)
		{
			System.out.println(sentence[j]);
			j++;
		}
		while(i < wordsToIgnore.length)
		{
			System.out.println(wordsToIgnore[i]);
			i++;
		}
	}

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String sentences;
		String ignoreWords;
		
		System.out.println("Enter list of sentences:");
		sentences = scanner.nextLine();
		System.out.println("Enter list of words to ignore:");
		ignoreWords = scanner.nextLine();
		
		KWIC k = new KWIC(sentences,ignoreWords);
        k.print();
	}

}
