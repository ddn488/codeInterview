package codeInterview.algorithm;

/**
 * Quicksort or partition-exchange sort, is a fast sorting algorithm, which is
 * using divide and conquer algorithm. Quicksort first divides a large list into
 * two smaller sub-lists: the low elements and the high elements. Quicksort can
 * then recursively sort the sub-lists.
 * 
 * Steps to implement Quick sort:
 * 
 * 1) Choose an element, called pivot, from the list. Generally pivot can be the
 * middle index element. 2) Reorder the list so that all elements : - with
 * values less than the pivot come before the pivot, - while all elements with
 * values greater than the pivot come after it - (equal values can go either
 * way). After this partitioning, the pivot is in its final position. This is
 * called the partition operation.
 * 
 * 3) Recursively apply the above steps to the sub-list of elements with smaller
 * values and separately the sub-list of elements with greater values.
 * 
 * @author dennis
 *  Big O Notation
 *  Time Complexity: O (log N)
 *
 */
public class MyQuickSort {
	
	public static void main(String a[]) {

		int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		
		MyQuickSort.sort(input);
		
		
		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public static void sort(int[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int[] array, int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;

		// calculate pivot number at the middle index number of the sub array
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays

		while (i <= j) {

			// walk the left side to the right until a number is less than the pivot value
			while (array[i] < pivot) {
				i++;
			}

			// walk the right side to the left until a number is greater than the pivot value
			while (array[j] > pivot) {
				j--;
			}

			// swap both numbers from high end to low end
			if (i <= j) {
				swap(array, i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}

		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(array, lowerIndex, j);
		if (i < higherIndex)
			quickSort(array, i, higherIndex);
	}

	// swap the values at i and j location 
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
