package codeInterview.codility;




public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 };

		Solution sol = new Solution();

		System.out.print(sol.solution(A));
	}

	public int solution(int[] A) {

		int deepestPit = -1;
		
		for(int i=0;i<A.length;i++) {
			
			for(int j=i+1;j<A.length;j++) {
				
				for(int k=j+1; k<A.length; k++) {
					
					int depth = depthCal(A, i, j, k);
					if( depth > -1) {
										
						if(depth > deepestPit) deepestPit = depth;
						
					}
				}
			}
			
		}
		
		
		return deepestPit;
		

	}

	int depthCal(int[] A, int p, int q, int r) {

		if (testSeq(A, p, q, r)) {

			return Math.min(A[p] - A[q], A[r] - A[q]);

		}

		return -1;
	}

	boolean testSeq(int[] A, int p, int q, int r) {

		if ( 0<=p && p < q && q < r) {
			
			for(int i=p;i<q;i++) {
				if( A[i] < A[i+1]) return false;
			}
			
			for(int i=q;i<r;i++) {
				if( A[i] > A[i+1]) return false;
			}
			
			
			return true;
		}
			
		return false;

	}
}
