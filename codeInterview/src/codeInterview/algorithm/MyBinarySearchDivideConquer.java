package codeInterview.algorithm;

/**
 * Program: Implement Binary search in java using divide and conquer technique.
 * 
 * A binary search or half-interval search algorithm finds the position of a
 * specified value (the input "number") within a sorted array. In each step, the
 * algorithm compares the input number value with the number value of the middle
 * element of the array. If the numbers match, then a matching element has been
 * found so its index, or position, is returned. Otherwise, if the sought number is
 * less than the middle element's number, then the algorithm repeats its action on
 * the sub-array to the left of the middle element or, if the input number is
 * greater, on the sub-array to the right. If the remaining array to be searched
 * is reduced to zero, then the number cannot be found in the array and a special
 * "Not found" indication is returned.
 * 
 * Every iteration eliminates half of the remaining possibilities. This makes
 * binary searches very efficient - even for large collections.
 * 
 * Binary search requires a sorted collection. Also, binary searching can only
 * be applied to a collection that allows random access (indexing).
 * 
 * Worst case performance: O(log n)
 * 
 * Best case performance: O(1) - See more at:
 * http://www.java2novice.com/java-search-algorithms/binary-search/#sthash.
 * gaFsBQE9.dpuf
 * 
 *
 */
public class MyBinarySearchDivideConquer {
	
	// code flow: 
	// 1) set start=0 and end= arrayLength-1
	// 2) loop while start <= end
	// 3) set middle index mid = (start+end)/2
	// 4) check the following condition: 
	// 		a) number == arr[mid]  return number
	//      b) number > arr[mid] set start = mid + 1
	//      c) number < arr[mid] set start = mid - 1
	
	public int binarySearch(int[] arr, int number) {

		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (number == arr[mid]) { 
				return mid;
			}
						
			if (number < arr[mid]) { // if number less than the mid value, set the new end =  mid  - 1
				end = mid - 1;
			} else {
				start = mid + 1;    // if the number larger than mid value, set the new start = mid + 1
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {

		MyBinarySearchDivideConquer mbs = new MyBinarySearchDivideConquer();
		int[] arr = { 2, 4, 6, 8, 10, 12, 14, 14, 14, 16 };
		System.out.println("Key 14's position: " + mbs.binarySearch(arr, 14));
//		int[] arr1 = { 6, 34, 78, 123, 432, 900 };
	}
}
