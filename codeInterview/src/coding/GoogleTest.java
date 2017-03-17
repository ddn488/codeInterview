package coding;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//1 -> {"a","b","c"}
//2 -> {"d","e","f"}
//3 -> {"g","h","i"}

//find the word: ice with all combination of characters in the sets

public class GoogleTest {

	public static void main(String[] args) {
		char[] arr1 = { 'a', 'b', 'c' };
		char[] arr2 = { 'd', 'e', 'f' };
		char[] arr3 = { 'g', 'h', 'i' };

		char[] combinedArr = new char[9];
		System.arraycopy(arr1, 0, combinedArr, 0, 3);
		System.arraycopy(arr2, 0, combinedArr, 3, 3);
		System.arraycopy(arr3, 0, combinedArr, 6, 3);

		searchPossibleCombinedChars(3, combinedArr, "", "ice");
	}

	static void searchPossibleCombinedChars(int maxLength, char[] arr, String cur, String searchStr) {

		if (cur.length() == maxLength) {
			if (cur.equals(searchStr)) {
				System.out.println(cur + " is found ..");
				return;
			}
		} else {

			for (int i = 0; i < arr.length; i++) {
				String oldCur = cur;
				cur += arr[i];
				searchPossibleCombinedChars(maxLength, arr, cur, searchStr);
				cur = oldCur; // reset to the previous value after the method return as cur.length = max length
			}

		}
	}

	// str = banana
	// bn -> true
	// nb -> false
	static void searchSequecialString() {
		String str = "banana";
		String input = "nb";
		String word = "";
		int startIndex = 0;

		for (int k = 0; k < input.length(); k++) {
			for (int i = startIndex; i < str.length(); i++) {

				if (input.charAt(k) == str.charAt(i)) {

					if (word.length() < input.length()) {
						word += input.charAt(k);
						startIndex = i + 1;
						break;
					}
				}
			}
		}

		System.out.println(word.equals(input));

	}
}
