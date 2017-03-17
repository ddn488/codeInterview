package codeInterview.algorithm;

/**
 * Merge sort is a divide and conquer algorithm.
 * 
 * Split the array in half and sort each subarray. Weave the arrays back together in one fluid pass.
 * 
 * Steps to implement Merge Sort:
 * 
 * 1) Divide the unsorted array into n partitions, each partition contains 1 element.
 *  Here the one element is considered as sorted.
 * 
 * 2) Repeatedly merge partitioned units to produce new sublists until there is only 1 sublist
 * remaining. This will be the sorted list at the end.
 * 
 * See more at: http://www.java2novice.com/java-sorting-algorithms/merge-sort/#sthash.2p2h15UI.dpuf
 * 
 * 
 * 		O(n log n) performance
 *		O(n) space
 *
 */
public class MyMergeSort {
	
	private int[] array;
	private int[] tempMergArr;
	private int length;

	public static void main(String a[]) {

		int[] arr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		MyMergeSort mms = new MyMergeSort();
		mms.sort(arr);
		for (int i : arr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int arr[]) {
		// set the input array to the array become the sorted array
		this.array = arr;
		this.length = arr.length;
		this.tempMergArr = new int[length];
		
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		// Recursive call this method for each sublist where the list divide by half
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		//copy the values from the original array to the tempMergArr
		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		
		while (i <= middle && j <= higherIndex) {
			// compare the value in the left array with the right array (starts from middle+1)
			
			// if the value of the left is lesser than the value of the right, move to the next left value
			if (tempMergArr[i] <= tempMergArr[j]) {
				// store the left value in the sorted array
				array[k] = tempMergArr[i];
				i++;
			} else {
				// the left value is greater than the right value,store the right value in the sorted array
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}
	}
}