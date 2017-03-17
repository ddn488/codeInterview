package codeInterview.algorithm;

import java.util.Arrays;

/**
 * Two words are anagrams of each other if they contain the same number of
 * characters and the same characters. You should only need to sort the
 * characters in lexicographic order, and compare if String a is equal to String
 * b at all steps.
 */
public class Anagrams {
	public static void main(String[] args) {
		System.out.print(Anagrams.isAnagram("john mayer", "enjoy harm"));
	}
	
	public static boolean isAnagram(String firstWord, String secondWord) {
		char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}
}
