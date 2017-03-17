package codeInterview.algorithm;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };
		sort(arr, 0, arr.length);
	}

	static void sort(int[] arr, int low, int high) {

		if (low == high)
			return;
		else {
			// divide the array in half
			int mid = (low + high) / 2;

			sort(arr, low, mid);
			sort(arr, mid + 1, high);

			merge(arr, low, mid, high);
		}
	}

	static void merge(int[] arr, int low, int mid, int high) {

		if (low == mid || mid == 1)
			return;

		int[] temp = new int[high - low];

		int index = 0;

		for (int i = low; i < mid; i++) {
			for (int j = mid + 1; j < high; j++) {
				if (arr[i] < arr[j]) {
					temp[index] = arr[i];
				} else {
					temp[index] = arr[j];
				}
				index++;
			}
		}

		printArr(temp);

	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == 0)
				System.out.print("[");
			System.out.print(arr[i]);
			if (i < arr.length - 1)
				System.out.print(" ,");
			if (i == arr.length - 1)
				System.out.print("]");
			;
		}
	}

}
