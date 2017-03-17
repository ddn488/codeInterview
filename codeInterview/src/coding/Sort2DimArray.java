package coding;

// Google Code Interview:
//Q. Given k sorted arrays of size n each, merge them and print the sorted output.

//Input:
//k = 3, n =  4
//arr[][] = { {1, 3, 5, 7},
//              {2, 4, 6, 8},
//              {0, 9, 10, 11}} ;
//
//Output: 0 1 2 3 4 5 6 7 8 9 10 11
//
//Don’t use Collection sort method

public class Sort2DimArray {

	public static void main(String a[]) {

		int arr[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11 } };

		int[] mergeA = new int[12];
		int start = 0;

		for (int k = 0; k < 3; k++) {
			for (int n = 0; n < 4; n++) {
				mergeA[start] = arr[k][n];
				System.out.print(mergeA[start]);
				start++;
			}
		}

		mergeSort(mergeA, 0, 12);

	}

	static void mergeSort(int[] array, int i, int j) {
		int mid = 0;

		if (i < j) {
			mid = (i + j) / 2;
			mergeSort(array, i, mid);
			mergeSort(array, mid + 1, j);

			merge(array, i, mid, j);
		}

	}

	//
	static void merge (int[] a, int i, int mid, int j) {
	    System.out.print("");
	    int temp[] = new int[a.length];
	    
	    int l=i;
	    int r=j;
	    int m = mid + 1;
	    int k = l;
	    
	    
	    while( l<= mid && m <= r) { 
	        if( a[l] <= a [m] ) {  // left side
	            temp[k++] = a [l++];
	        }
	        else {
	         temp[k++] = a [m++] ;
	        }
	        
	        while (l <= mid) {
	            temp[k++] = a[l++];
	        }
	        
	        while (m <= r) {
	            temp[k++] = a[m++];
	        }
	        
	        for(int z = i; z < j; z++) {
	            a[z] = temp[z];
	            System.out.print(a[z]);
	        }
	        
	    }
	}
}
	
