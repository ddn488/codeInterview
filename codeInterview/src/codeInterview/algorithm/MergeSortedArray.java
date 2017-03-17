package codeInterview.algorithm;

import java.util.Arrays;

public class MergeSortedArray {

	public static void main(String[] args) {
		int a[] = { 10, 20, 30 };
		int b[] = { 9, 14, 11 };

		int[] result = MergeSortedArray.merge(a, b);
		for (int i=0;i<result.length;i++) {
			System.out.print(result[i]);
			System.out.print(' ');
		}
		
	}

	public static int[] merge(int[] a, int[] b) {
		int[] answer = new int[a.length + b.length];
		int i = a.length - 1, j = b.length - 1, k = answer.length;

		while (k > 0)
			answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
		return answer;
	}

	// use Array.sort
	public static int[] mergeArray(int[] a, int[] b) {
		int[] answer = new int[a.length + b.length];

		System.arraycopy(a, 0, answer, 0, a.length);
		System.arraycopy(b, 0, answer, a.length, b.length);
		Arrays.sort(answer);

		return answer;
	}

	private <T> void mergeObjects(Comparable<T>[] array1, Comparable<T>[] array2) {
		int higherIndex1 = array1.length - 1;
		int highIndex2 = array2.length - 1;
		Object[] result = new Object[array1.length + array2.length];

		int k = 0;
		for (int i = 0; i < higherIndex1; i++) {
			for (int j = 0; j < highIndex2; j++) {
				if (array1[i].compareTo((T) array2[j]) <= 0) {
					result[k] = array1[i];
				} else {
					result[k] = array2[j];
				}
				k++;
			}
		}
	}
}
