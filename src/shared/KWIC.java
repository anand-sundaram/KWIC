/*
 * Implementation of KWIC using "Data abstraction 
 * and Object-Oriented Organisation" design style
 * Implemented by: Rupali Roy Choudhury
 * Matric num: A0102796B
 */

package shared; 

import java.util.*;
import java.util.ArrayList;

public class KWIC 
{
	ArrayList<String> appendedListOfSentences = new ArrayList<String>();
	String [] wordsToIgnore;
	String [] sentence;
	String [] words;
	String joinedWords;
	
	/*************************************************************
	assign the arrays with the individual words separated by ","
	**************************************************************/
	KWIC(String sentences, String ignoreWords)
	{
		sentence = sentences.split(", |,");
		wordsToIgnore = ignoreWords.split(", |,");
	}
	
	/*************************************************************************************************
	appends those sentences in the array whose first word is not in the list of "words to be ignored"
	**************************************************************************************************/
	public void append(String words[])
	{
		int i = 0, flag = 0; 									// when flag is 0 means the first word of the sentence does not start with "words to be ignored"
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
			joinedWords = String.join(" ", words);     			// assembles the individual words to a sentence separated by a space
			appendedListOfSentences.add(joinedWords);  			// appends the sentences to the given array
			sortInAlphabeticOrder();
		}
	}
	
	/*****************************************************************************************
	splits the sentences in the array index by a space and does a circular shift of the words
	******************************************************************************************/
	public void splitAndCircularShiftIndex(String str)
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
	
	/****************************************************
	 each array index is sent for manipulation
	 ****************************************************/
	public void logic()
	{
		int i;
		for(i = 0; i < sentence.length; i++)
		{
			splitAndCircularShiftIndex(sentence[i]);
		}
	}
	
	/**************************************************
	sorts the array according to alphabetical order
	***************************************************/
	public void sortInAlphabeticOrder()
	{
		Collections.sort(appendedListOfSentences,String.CASE_INSENSITIVE_ORDER);
	}
	
	/***********************************
	displays the content of the array
	************************************/
	public void print()
	{
		int j = 0;
		while(j < appendedListOfSentences.size())
		{
			System.out.println(appendedListOfSentences.get(j));
			j++;
		}
	}

//	public static void main(String[] args) 
//	{
//		Scanner scanner = new Scanner(System.in);
//		String sentences;
//		String ignoreWords;
//		
//		System.out.println("Enter list of sentences:");
//		sentences = scanner.nextLine();
//		System.out.println("Enter list of words to ignore:");
//		ignoreWords = scanner.nextLine();
//		
//		KWIC k = new KWIC(sentences,ignoreWords);
//		k.logic();
//        k.print();
//	}
}
