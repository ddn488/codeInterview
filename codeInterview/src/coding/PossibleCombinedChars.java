package coding;

public class PossibleCombinedChars {

	
	public static void main(String[] args) {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f','g','h', 'i' };

		possibleString(3, alphabet, "");
	}

	static void possibleString(int maxLength, char[] alphabet, String cur) {

		if (cur.length() == maxLength) {
			if( cur.equals("ice")) {
				System.out.println(cur);
				return;
			}

		} else {

			for (int i = 0; i < alphabet.length; i++) {
				String oldCur = cur;
				cur += alphabet[i];
				possibleString(maxLength, alphabet, cur);
				cur = oldCur; // reset to the previous value after the method return as cur.length = max length
			}
		}

	}

}
