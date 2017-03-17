package codeInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * Find first sustring consists of unique characters in given word [ex. google
 * -> ogle]
 * 
 * @author dennis
 *
 */
public class SubstringUniqueChars {

	public static void main(String[] args) {
		String result = subStringUniqueChars("googleaward");
		System.out.println(result == null ? "" : result);
	}

	static String subStringUniqueChars(String str) {
		
		int maxLength = 0;
		String longestSubString="";
		
		for (int i = 0; i < str.length(); i++) {

			for (int j = str.length(); j > i ; j--) {
				String subString = str.substring(i, j);

				Set<Character> charSet = new HashSet<Character>();

				for (int k = 0; k < subString.length(); k++) {
					charSet.add(subString.charAt(k));
				}

				if (subString.length() == charSet.size()) {
					if (subString.length() > maxLength) {
						maxLength=subString.length();
						longestSubString = subString;
					}
				}
					
			}
		}

		return longestSubString;
	}

}
