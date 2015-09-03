/*
 * Implementation of KWIC using "Shared repository" design style
 * Implemented by: Anand Sundaram
 * Matric num: A0118897J
 */

package shared;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MasterControl {

	public static ArrayList<String> wordsToIgnore = new ArrayList<String>();
	public static ArrayList<String> titles = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> titlesByWords;
	public static ArrayList<ArrayList<Integer>> index;
	public static ArrayList<ArrayList<Integer>> alphabetizedIndex;
	
	public static ArrayList<String> outputTitles = new ArrayList<String>();
	
	static void splitter(String sentences, String ignoreWords) {
		String[] sentence = sentences.toLowerCase().split(", |,");
		String[] wordsToIgnore = ignoreWords.toLowerCase().split(", |,");
		
		MasterControl.wordsToIgnore.addAll(Arrays.asList(wordsToIgnore));
		MasterControl.titles.addAll(Arrays.asList(sentence));
	}
	static void circularShifter() {
		index = new ArrayList<ArrayList<Integer>>();
		titlesByWords = new ArrayList<ArrayList<String>>(titles.size());
		for (int x = 0; x < titles.size(); x++) {
			StringTokenizer str = new StringTokenizer(titles.get(x));
			titlesByWords.add(new ArrayList<String>());
			int numberOfWords = str.countTokens();
			for (int y = 0; y < numberOfWords; y++) {
				String word = str.nextToken();
				titlesByWords.get(x).add(word);
				if (!wordsToIgnore.contains(word)) {
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(x);
					arr.add(y);
					index.add(arr);
				}
			}
		}
	}
	static void alphabetizer() {
		ArrayList<Integer> min = new ArrayList<Integer>();
		alphabetizedIndex = new ArrayList<ArrayList<Integer>>();
		int minPos = 0;
		int numberOfKeywords = index.size();;
		for (int x = 0; x < numberOfKeywords; x++) {
			min = index.get(0);
			minPos = 0;
			for (int y = 1; y < index.size(); y++) {
				int a1 = min.get(0);
				int b1 = min.get(1);
				int a2 = index.get(y).get(0);
				int b2 = index.get(y).get(1);
				
				if (titlesByWords.get(a1).get(b1).compareTo(titlesByWords.get(a2).get(b2)) > 0) {
					minPos = y;
					min = index.get(minPos);
				}
			}
			alphabetizedIndex.add(index.get(minPos));
			index.remove(minPos);
		}
	}
	static void output() {
		for (int x = 0; x < alphabetizedIndex.size(); x++) {
			int titleNumber = alphabetizedIndex.get(x).get(0);
			int startingIndex = alphabetizedIndex.get(x).get(1);
			String line = titlesByWords.get(titleNumber).get(startingIndex).toUpperCase() + " ";
			for (int y = startingIndex + 1; y < titlesByWords.get(titleNumber).size(); y++) {
				line = line + titlesByWords.get(titleNumber).get(y).toLowerCase() + " ";
			}
			for (int y = 0; y < startingIndex; y++) {
				line = line + titlesByWords.get(titleNumber).get(y).toLowerCase() + " ";
			}
			outputTitles.add(line);
		}
		
		for (int x = 0; x < outputTitles.size(); x++) {
			System.out.println(outputTitles.get(x));
		}
	}
}
