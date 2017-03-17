package codeInterview.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.*;


public class WordCounter {

	public HashMap<String, Integer> countWords(String document) {
		HashMap<String, Integer> counts = new HashMap<String, Integer>();

		for (String word : document.split(" ")) {
			String key = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
			if (counts.containsKey(key)) {
				counts.put(key, counts.get(key) + 1);
			} else {
				counts.put(key, 1);
			}
		}
		return counts;
	}

	@Test
	public void testCountWords() {

		Map<String, Integer> c = countWords("am out am out am out out");

		// the max repeat works
		int max = 0;
		String maxRepeatedWords = "";
		Iterator<Entry<String, Integer>> i = c.entrySet().iterator();
		while (i.hasNext()) {
			Entry<String, Integer> e = i.next();
			if (e.getValue() > max) {
				maxRepeatedWords = e.getKey();
				max = e.getValue();
			}
		}
		
		Assert.assertTrue(maxRepeatedWords.equals("out"));
	}

}
