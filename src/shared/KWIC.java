/*
 * Implementation of KWIC using "Data abstraction 
 * and Object-Oriented Organisation" design style
 */

import java.util.*;
import java.util.ArrayList;

public class KWIC 
{
	String [] sentence;
	ArrayList<String> possibleShifts = new ArrayList<String>();
	//String []appendedWords = new String[10];
	ArrayList<String> appendedWords = new ArrayList<String>();
	String [] wordsToIgnore;
	String [] words;
	String msg;
	int index = 0;
	
	KWIC(String sentences, String ignoreWords)
	{
		sentence = sentences.split(", ");
		wordsToIgnore = ignoreWords.split(", ");
	}
	
	public void append(String words[])
	{
		int i = 0, flag = 0;
		for(i = 0; i < wordsToIgnore.length; i++)
		{
			if(words[0].equalsIgnoreCase(wordsToIgnore[i]))
			{
				flag ++;
				break;
			}
			
		}
		if(flag == 0)
		{
			msg = String.join(" ", words);
			appendedWords.add(msg);
			Collections.sort(appendedWords,String.CASE_INSENSITIVE_ORDER);
			System.out.println(appendedWords);
		}
	}
	
	public void splitIndex(String str)
	{
		int i, k;
		words = str.split(" ");
		String strTemp;
		int count = words.length;
		for(k = 0 ; k < count; k++)
		{
			strTemp = words[0];
			for(i = 0; i < words.length - 1; i++)
			{
				words[i] = words[i+1];
			}
			words[i] = strTemp;
		    append(words);		
			i = 0;
		}
	}
	
	public void circularShift()
	{
		int i;
		for(i = 0; i < sentence.length; i++)
		{
			splitIndex(sentence[i]);
		}
	}
	
	/*public void sort()
	{
		int i, j;
		String temp;
		for(i = 0; i < sentence.length; i++)
		{
			for(j = i+1; j < sentence.length; j++)
			{
				if(sentence[i].compareToIgnoreCase(sentence[j]) > 0)
				{
					temp = sentence[i];
					sentence[i] = sentence[j];
					sentence[j] = temp;
				}
			}
		}
	}
	
	public void print()
	{
		int i = 0, j = 0;
		while(j < sentence.length)
		{
			System.out.println(sentence[j]);
			j++;
		}
	}*/

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
		k.circularShift();
		//k.sort();
       // k.print();
	}

}
