package codeInterview.codility;

public class DemoTest {

	public static void main(String[] args) {
		int[] A = { -1, 3, -4, 5, 1, -6, 2, 1 };

		DemoTest test = new DemoTest();
		
		test.solution(A);

	}
	
	public int solution(int[] A) {

		int r = -1;
		for (int i = 1; i < A.length; i++) {

			if (isEquilIndex(A, i)) {
				System.out.print(i + " ");
				r = 0;
			}
		}

		return r;
	}

	 boolean isEquilIndex(int[] A, int n) {

		int sumPreFix = 0;
		int sumSufix = 0;
		
		for (int i = 0; i < n; i++) {
			sumPreFix += A[i];
		}

		for (int j = n + 1; j < A.length; j++) {
			sumSufix += A[j];
		}

		if (sumPreFix == sumSufix) {
			return true;
		}
		return false;
	}
	

/*	public int solution(int[] A) {
		
		int count = 0;
		for (int k = 1; k < A.length; k++) {
			int sumPreFix = 0;
			int sumSufix = 0;
			
			int test = k;
			
			for (int i = 0; i < test; i++) {
				sumPreFix += A[i];
			}

			for (int j = test + 1; j < A.length; j++) {
				sumSufix += A[j];
			}

			if (sumPreFix == sumSufix) {
				return k;
				count++;
			}
		}

		return count > 0 ? count:-1;
//	}
*/
}
//	
//	
//	Codility - we test coders Training center
//	Check out Codility training tasks
//	Dennis Nguyen
//	Session
//	ID: demo4VPKSV-3RK
//	Time limit: 30 min.
//	Status: closed
//	Created on: 2017-03-13 15:03 UTC
//	Started on: 2017-03-13 15:03 UTC
//	Finished on: 2017-03-13 15:19 UTC
//	Test score 
//	35%
//	35 out of 100 points
//	Tasks in test	Correctness	Performance	Task score
//	1  Equi Submitted in: Java	
//	26%	
//	54%	35%	
//	MEDIUM
//	score: 35 of 100
//	1. Equi
//	Find an index in an array such that its prefix sum equals its suffix sum.
//	Task description
//	This is a demo task.
//
//	A zero-indexed array A consisting of N integers is given. An equilibrium index of this array is any integer P such that 0 ≤ P < N and the sum of elements of lower indices is equal to the sum of elements of higher indices, i.e. 
//	A[0] + A[1] + ... + A[P−1] = A[P+1] + ... + A[N−2] + A[N−1].
//	Sum of zero elements is assumed to be equal to 0. This can happen if P = 0 or if P = N−1.
//
//	For example, consider the following array A consisting of N = 8 elements:
//
//	  A[0] = -1
//	  A[1] =  3
//	  A[2] = -4
//	  A[3] =  5
//	  A[4] =  1
//	  A[5] = -6
//	  A[6] =  2
//	  A[7] =  1
//	P = 1 is an equilibrium index of this array, because:
//
//	A[0] = −1 = A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
//	P = 3 is an equilibrium index of this array, because:
//
//	A[0] + A[1] + A[2] = −2 = A[4] + A[5] + A[6] + A[7]
//	P = 7 is also an equilibrium index, because:
//
//	A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] = 0
//	and there are no elements with indices greater than 7.
//
//	P = 8 is not an equilibrium index, because it does not fulfill the condition 0 ≤ P < N.
//
//	Write a function:
//
//	class Solution { public int solution(int[] A); }
//
//	that, given a zero-indexed array A consisting of N integers, returns any of its equilibrium indices. The function should return −1 if no equilibrium index exists.
//
//	For example, given array A shown above, the function may return 1, 3 or 7, as explained above.
//
//	Assume that:
//
//	N is an integer within the range [0..100,000];
//	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
//	Complexity:
//
//	expected worst-case time complexity is O(N);
//	expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
//	Elements of input arrays can be modified.
//
//	Copyright 2009–2017 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
//	 	
//	Solution
//	Programming language used: Java
//	Total time used: 16 minutes
//	Effective time used: 16 minutes
//	Notes:  
//	not defined yet
//	Task timeline
//
//	  
//	  
//	  
//	  
//	  
//	15:19:23
//	15:03:35
//	Code: 15:19:23 UTC, java, final, score:  35
//	show code in pop-up
//	1
//	2
//	3
//	4
//	5
//	6
//	7
//	8
//	9
//	10
//	11
//	12
//	13
//	14
//	15
//	16
//	17
//	18
//	19
//	20
//	21
//	22
//	23
//	24
//	25
//	26
//	27
//	28
//	29
//	30
//	31
//	32
//	33
//	34
//	35
//	// you can also use imports, for example:
//	// import java.util.*;
//
//	// you can write to stdout for debugging purposes, e.g.
//	// System.out.println("this is a debug message");
//
//	class Solution {
//	    public int solution(int[] A) {
//	        // write your code in Java SE 8
//	        int count = 0;
//	        int eNumber=-1;
//			for (int k = 1; k < A.length; k++) {
//				int sumPreFix = 0;
//				int sumSufix = 0;
//				
//				int test = k;
//				
//				for (int i = 0; i < test; i++) {
//					sumPreFix += A[i];
//				}
//
//				for (int j = test + 1; j < A.length; j++) {
//					sumSufix += A[j];
//				}
//
//				if (sumPreFix == sumSufix) {
//					//System.out.print(test + " ");
//					count++;
//				    return test;	
//				}
//			}
//
//			return count > 0 ? count:-1;
//	    }
//	}
//	Analysis summary
//	The following issues have been detected: wrong answers, timeout errors.
//
//	For example, for the input [0] the solution returned a wrong answer (got -1, but equilibrium point exists, for example on position 0 of A = [0]).
//
//	Analysis
//	expand allExample tests
//	▶ example 
//	Test from the task description ✔OK
//	expand allCorrectness tests
//	▶ simple ✔OK
//	▶ extreme_large_numbers 
//	Sequence with extremely large numbers testing arithmetic overflow. ✘WRONG ANSWER 
//	got 2, but it is not equilibrium point, sum[0..1]=4294967294, sum[3..3]=-2
//	1. 0.063 s WRONG ANSWER,  got 2, but it is not equilibrium point, sum[0..1]=4294967294, sum[3..3]=-2
//	2. 0.065 s OK
//	▶ extreme_negative_numbers 
//	Sequence with extremely large numbers testing arithmetic overflow. ✘WRONG ANSWER 
//	got -1, but equilibrium point exists, for example on position 0 of A = [-2147483648]
//	▶ overflow_tests1 
//	arithmetic overflow tests ✘WRONG ANSWER 
//	got 2, but it is not equilibrium point, sum[0..1]=-4294967296, right sum (empty set)=0
//	▶ overflow_tests2 
//	arithmetic overflow tests ✘WRONG ANSWER 
//	got 2, but it is not equilibrium point, sum[0..1]=-4294967296, right sum (empty set)=0
//	▶ one_large 
//	one large number at the end of the sequence ✘WRONG ANSWER 
//	got -1, but equilibrium point exists, for example on position 0 of A = [500, 1, -2, -1, 2]
//	▶ sum_0 
//	sequence with sum=0 ✔OK
//	▶ single_empty 
//	single number or empty array ✘WRONG ANSWER 
//	got -1, but equilibrium point exists, for example on position 0 of A = [0]
//	▶ combinations_of_two 
//	multiple runs, all pairs of values: -1, 0 and 1 ✘WRONG ANSWER 
//	got -1, but equilibrium point exists, for example on position 0 of A = [-1, 0]
//	▶ combinations_of_three 
//	multiple runs, all triples of values -1, 0 and 1 ✘WRONG ANSWER 
//	got -1, but equilibrium point exists, for example on position 0 of A = [-1, -1, 1]
//	▶ small_pyramid ✔OK
//	expand allCorrectness/performance tests
//	▶ extreme_max 
//	Maximal size test ✘TIMEOUT ERROR 
//	running time: >7.00 sec., time limit: 1.82 sec.
//	expand allPerformance tests
//	▶ large_long_sequence_of_ones ✘TIMEOUT ERROR 
//	running time: >7.00 sec., time limit: 1.98 sec.
//	▶ large_long_sequence_of_minus_ones ✘TIMEOUT ERROR 
//	running time: >7.00 sec., time limit: 1.80 sec.
//	▶ medium_pyramid ✔OK
//	▶ large_pyramid 
//	Large performance test, O(n^2) solutions should fail. ✔OK
//	▶ huge_pyramid 
//	Large performance test, O(n^2) solutions should fail. ✔OK
//	Training center
//	Congratulations
//	You have completed a Codility demo. 
//	Return to proper test
