package codeInterview.practice;

/*Find the majority element. In this problem, majority element is defined as the number that appears more than 
 * n/ 2 times in an array of numbers.
 * 
 * Solution 
 * Time Complexity O(N)
 * Space Complexity O(1)
*/

public class MajorityCandidate {

	public static void main(String[] args) {

		int[] arr = { 3, 2, 2, 1, 2, 2, 1 };
		
		int maj = findMajCandidate(arr);
		
		if(verifyMajCandidate(arr, maj)) System.out.println("Majority element: " + maj);
		else System.out.println("No majority element found");
	}

	static int findMajCandidate(int[] arr) {
		if (arr == null || arr.length == 0) {
			return Integer.MIN_VALUE;
		}

		int count = 1;
		int maj = arr[0]; // start with the fist element

		for (int i = 0; i < arr.length; i++) {
			if (maj == arr[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				maj = arr[i];
				count = 1;
			}
		}

		return maj;
	}

	static boolean verifyMajCandidate(int[] arr, int maj) {
		if(arr == null || arr.length == 0) return false;
		
		int length = arr.length; int count = 0;
		
		for(int i=0; i<arr.length;i++) {
			if(maj == arr[i]) {
				count++;
			}
			if(count > length/2) return true;
		}
		
		return false;
	}

}
