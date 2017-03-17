package codeInterview;

/**
 * Find the kth smallest element form the given sequence of numbers For example:
 * Array[] = 811 30 934 118 942 89 855 917 474 194 630 887 916 997 851 550 917
 * 841 343 202
 * 
 * if K = 3, the smallest number at position 3 is 118
 * 
 * USE QuickSelect without sorting: https://en.wikipedia.org/wiki/Quickselect
 * 
 * Like quicksort, it is efficient in practice and has good average-case
 * performance, but has poor worst-case performance.
 * 
 * Quickselect and its variants are the selection algorithms most often used in
 * efficient real-world implementations. Quickselect uses the same overall
 * approach as quicksort, choosing one element as a pivot and partitioning the
 * data in two based on the pivot, accordingly as less than or greater than the
 * pivot. However, instead of recursing into both sides, as in quicksort,
 * quickselect only recurses into one side – the side with the element it is
 * searching for. This reduces the average complexity from O(n log n) to O(n),
 * with a worst case of O(n2).
 * 
 * @author
 *
 */

public class KthSmallestInArrayQuickSelect {

	public static void main(String[] args) {

		int[] array = { 811, 30, 934, 118, 942, 89, 855, 917, 474, 194, 630, 887, 916, 997, 851, 550, 917, 841, 343,
				202 };
		int k = 3;
		int kthValue = select(array, 0, array.length - 1, k-1); // because k is base of 1 while the array is zero based therefore k-1
		System.out.println("K = " + k + " then The " + k + "th smallest number is : " + kthValue);

	}

	public static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right);

		int storeIndex = left;

		for (int i = left; i < right; i++) {
			if (array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}

			swap(array, right, storeIndex);
		}

		return storeIndex;

	}

	public static int select(int[] array, int left, int right, int k) {
		if (left == right)
			return array[left];

		int pivotIndex = (left + right) / 2;

		pivotIndex = partition(array, left, right, pivotIndex);

		if (k == pivotIndex)
			return array[k];
		else if (k < pivotIndex)
			return select(array, left, pivotIndex - 1, k);
		else
			return select(array, pivotIndex + 1, right, k);

	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
