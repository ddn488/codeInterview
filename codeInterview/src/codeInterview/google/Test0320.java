package codeInterview.google;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * How to find the first (in terms of occurrence in input, not
 * lexicographically) non-repeated character of a given String? Write the
 * solution as a Java method, with the following signature: Character
 * firstUniqueChar(String input)
 * 
 * For example: firstUniqueChar("find first non repeated character of a given
 * String") should return: ‘s’
 * 
 * @author dennis
 *
 */

public class Test0320 {

	public static void main(String[] args) {
		System.out.println(firstUniqueChar("find first non repeated character of a given String"));

	}

	static Character firstUniqueChar(String input) {
		// TreeMap has the order insertion
		Map<Character, Integer> m = new TreeMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (m.containsKey(Character.valueOf(c))) {
				m.put(Character.valueOf(c), Integer.valueOf(m.get(c) + 1));
			} else {
				m.put(Character.valueOf(c), Integer.valueOf(1));
			}
		}

		
		Iterator<Character> it = m.keySet().iterator();
		while (it.hasNext()) {
			Character c = it.next();
			if (m.get(c) == 1)
				return c;

		}

		return null;
	}

}


