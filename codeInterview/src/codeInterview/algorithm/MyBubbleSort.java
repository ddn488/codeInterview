package codeInterview.algorithm;

/**
 * 
 * Program: Implement bubble sort in java.
 * 
 * Bubble sort, also referred to as sinking sort, is a simple sorting algorithm
 * that works by repeatedly stepping through the list to be sorted, 
 *  - comparing each pair of adjacent items and swapping them if they are in the wrong order.
 * The pass through the list is repeated until no swaps are needed, which
 * indicates that the list is sorted. The algorithm gets its name from the way
 * smaller elements "bubble" to the top of the list. Because it only uses
 * comparisons to operate on elements, it is a comparison sort. Although the
 * algorithm is simple, most of the other sorting algorithms are more efficient
 * for large lists. - See more at:
 * http://www.java2novice.com/java-sorting-algorithms/bubble-sort/#sthash.
 * eBT8sgTz.dpuf
 * 
 * O(n^2) performance O(1) space
 *
 * 
 */
public class MyBubbleSort {

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		bubbleSort(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println("\n");
	}

	// logic to sort the elements:
	public static void bubbleSort(int array[]) {
		// two for-loop from the end to start and the start -> end
		for (int m = array.length; m >= 0; m--) {
			
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					swap(i, i + 1, array);
				}
			}
			
		}

	}

	private static void swap(int i, int j, int[] array) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
