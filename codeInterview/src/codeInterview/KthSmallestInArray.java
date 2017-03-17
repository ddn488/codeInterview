package codeInterview;

/**
 * Find the kth smallest element form the given sequence of numbers For example:
 * Array[] = 811 30 934 118 942 89 855 917 474 194 630 887 916 997 851 550 917
 * 841 343 202
 * 
 * if K = 3, the smallest number at position 3 is 118
 * 
 * Solution : - Sort the array in ascending order using quick sort - the Kth
 * smallest number = sortedArray[K];
 * 
 * QUICK SORT:
 * 
 * 1) Choose an element, called pivot, from the list. Generally pivot can be the
 * middle index element. 
 * 2) Reorder the list so that all elements : 
 * - with values less than the pivot come before the pivot, 
 * - while all elements with values greater than the pivot come after it - (equal values can go either
 * way)
 * . After this partitioning, the pivot is in its final position. This is
 * called the partition operation.
 * 
 * 3) Recursively apply the above steps to the sub-list of elements with smaller
 * values and separately the sub-list of elements with greater values.
 * 
 * @author
 *
 */

public class KthSmallestInArray {

	public static void main(String[] args) {

		int[] array = { 811, 30, 934, 118, 942, 89, 855, 917, 474, 194, 630, 887, 916, 997, 851, 550, 917, 841, 343,
				202 };
		
		int[] sortedArray = quickSort(array, 0, array.length - 1);

		int k = 3;
		System.out.println("The " + k + "th smallest number is : " + sortedArray[k - 1]);

	}

	public static int[] quickSort(int[] array, int low, int high) {

		int i = low;
		int j = high;
		int pivotIndex = (low + high) / 2;// set the pivot at the middle
		int pivotValue = array[pivotIndex];

		while (i <= j) {
			// increase the low index while the value is smaller the pivot value
			while (array[i] < pivotValue)
				i++;

			// decrease the high index while the value is larger the pivot value;
			while (array[j] > pivotValue)
				j--;

			// swap the values
			if (i <= j) {
				swap(array, i, j);
				// move to the next index
				i++;
				j--;
			}
		} // end of while loop

		// recursive calls until the below conditions are not true 
		if (low < j) {
			quickSort(array, low, j);
		}

		if (high > i) {
			quickSort(array, i, high);
		}

		return array;

	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
