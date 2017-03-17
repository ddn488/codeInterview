package codeInterview.algorithm;

/**
 * 
 * Insertion sort is a simple sorting algorithm, it builds the final sorted array one item at a time. 
 * It is much less efficient on large lists than other sort algorithms.

Advantages of Insertion Sort:

1) It is very simple.
2) It is very efficient for small data sets.
3) It is stable; i.e., it does not change the relative order of elements with equal keys.
4) In-place; i.e., only requires a constant amount O(1) of additional memory space.

Insertion sort iterates through the list by consuming one input element at each repetition, 
and growing a sorted output list. On a repetition, insertion sort removes one element
 from the input data, finds the location it belongs within the sorted list, 
 and inserts it there. It repeats until no input elements remain.
- See more at: http://www.java2novice.com/java-sorting-algorithms/insertion-sort/#sthash.WmCszMv3.dpuf
 *
 */
public class MyInsertionSort {

	public static void main(String a[]) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doInsertionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}

	public static int[] doInsertionSort(int[] input) {
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					swap(input, j, j-1);
				}
			}
		}
		return input;
	}
	
	static void swap(int[] arr,int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
/*
 * Output:
 * 
 * 2, 7, 10, 34, 42, 56, 67, 88,
 */
