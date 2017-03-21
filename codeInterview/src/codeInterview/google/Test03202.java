package codeInterview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a String, find the longest consecutive substring that contains only two
 * unique characters. Write the solution as a Java method, with the following
 * signature: String longest2CharacterSubstring(String input)
 * 
 * For example: longest2CharacterSubstring("abcbbbbcccbdddadacb") should return
 * "bcbbbbcccb"
 * 
 * @author dennis
 *
 */

public class Test03202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longest2CharacterSubstring("abcbbbbcccbdddadacb"));
	}

	static String longest2CharacterSubstring(String input) {
		return findLongest(input, 2, 0, input.length() - 1);
	}

	static String findLongest(String input, int maxUniqueChars, int start, int end) {
		
		if(input == null) return null;
		
		int mid = input.length() / 2;
		for (int i = start; i < mid; i++) {
			for (int j = end; j > mid + 1; j--) {
				String sub = input.substring(i, j);
				if (nUniqueChars(sub) == maxUniqueChars)
					return sub;

			}
		}

		return null;

	}

	static int nUniqueChars(String input) {
		Set<Character> s = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			s.add(input.charAt(i));
		}
		return s.size();
	}

}
