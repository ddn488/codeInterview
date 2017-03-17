package codeInterview.algorithm;

import org.junit.Test;

public class PermutationInString {
	//
	@Test
	public void testPermInOrder() {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, 3);
		 permInOrder("", elements);
	}

	// print N! permutation of the elements of array a (not in order)
	@Test
	public void testPermNotInOrder() {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String elements = alphabet.substring(0, 3);
		int N = elements.length();
		char[] a = new char[N];
		for (int i = 0; i < N; i++)
			a[i] = elements.charAt(i);
		permNotInOrder(a, N);
	}

	// print N! permutation of the characters of the string s (in order)
	public void permInOrder(String prefix, String s) {
		int N = s.length();
		
		if (s.length() > 0) {
			for (int i = 0; i < N; i++)
				permInOrder(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
		}
		
	}

	public void permNotInOrder(char[] a, int n) {
		if (n == 1) {
			System.out.println(a);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			permNotInOrder(a, n - 1);
			swap(a, i, n - 1);
		}
	}

	// swap the characters at indices i and j
	private void swap(char[] a, int i, int j) {
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
}
