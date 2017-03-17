package codeInterview.algorithm;

/**
 * 
 * Perform the division operation without using '/'.
 *
 */
public class DivideNumber {

	public static void main(String[] args) {

		// System.out.print(DivideNumber.quickDivide(2345678, 234));
		System.out.print(DivideNumber.quickDivide2(2345678, 234));
	}

	/**
	 * Divide a number without using "/" - use multiplication instead
	 * 
	 * @param num
	 * @param temp
	 * @return
	 */
	public static String quickDivide(int num, int denom) {
		int multiplier = 0, temp = 0;

		while (num >= temp) {
			multiplier++;
			temp = denom * multiplier;
		}

		return "" + (multiplier - 1) + " remainder:" + (num - (denom * (multiplier - 1)));
	}

	/**
	 * performing division without +,-, * or /
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int quickDivide2(int dividend, int divisor) {
		
		int temp = divisor;
		int current = 1;
		int answer = 0;

		if (divisor > dividend)
			return 0;

		if (divisor == dividend)
			return 1;

		// use Signed left shift << increase the number until larger then the divident
		while (temp < dividend) {
			temp = temp << 1;				// equivalent to the number (*2)(*2)...
			current = current << 1;
		}

		// Signed right shift >> to find the result util the divident lesser than the temp
		while (current != 0) {
			if (dividend >= temp) {
				dividend -= temp;
				answer |= current;
			}
			current = current >> 1; // equivalent to the number (/2)(/2)...
			temp = temp >> 1;
		}

		return answer;
	}

	private static int binaryDivide(int dividend, int divisor) {
		int current = 1;
		int temp = divisor;
		// This step is required to find the biggest current number which can be
		// divided with the number safely.
		while (temp <= dividend) {
			current <<= 1;
			temp <<= 1;
		}
		// Since we may have increased the denomitor more than dividend
		// thus we need to go back one shift, and same would apply for current.
		temp >>= 1;
		current >>= 1;
		int answer = 0;
		// Now deal with the smaller number.
		while (current != 0) {
			if (dividend >= temp) {
				dividend -= temp;
				answer |= current;
			}
			current >>= 1;
			temp >>= 1;
		}
		return answer;
	}
}
