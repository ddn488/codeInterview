package codeInterview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a function that returns the numbers that have multiple occurrences in a list of 100 integers
 * @author dennis
 *
 */

public class TestOrangeLogicIrvine {
	public static void main(String[] args) {

		int[] array = { -5, -3, -1, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 6, 7, 7, 8, 8 };
		System.out.println(mupltipleOccurNumbers(array).toString());
	}

	static int[] mupltipleOccurNumbers(int[] input) {

		// TreeMap keeps the order of inseration
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();

		for (int i = 0; i < input.length; i++) {
			if (m.get(input[i]) != null) {
				m.put(input[i], m.get(input[i]) + 1);
			} else {
				m.put(input[i], 1);
			}
		}

		List<Integer> l = new ArrayList<Integer>();

		m.forEach((key, value) -> {
			if (value > 1) {
				l.add(key);
			}
		});

		int[] r = new int[l.size()];

		for (int i = 0; i < l.size(); i++) {
			r[i] = l.get(i).intValue();
		}

		return r;
	}
}
