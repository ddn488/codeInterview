package codeInterview;

import org.junit.Assert;
import org.junit.Test;


// Questions: You are passed a sorted array, 
// write code that finds the number of 0s in the array. Please try to implement this as a log N solution

//Algorithms that run in O(log(n)) usually work by discarding a significant portion of the problem space with each step.
//For example, in a binary search, each step reduces the number of places to look by half. You can cut an array of length 
//nn a maximum of log2(n)log2⁡(n) times before you're left with only 1 element, hence binary search has a running time in O(log(n))

// 1) Use Binary search to get index of the first occurrence of number  in arr[]. Let the index of the first occurrence be i.
// 2) Use Binary search to get index of the last occurrence of number  in arr[]. Let the index of the last occurrence be j.
// 3) Return (j – i + 1);

public class CountNumbersInArray {


	public static void main(String[] args) {
		
		int[] array = {-5,-3,-1,0,0,0,0,0,0,0,1,2,3,4,5,6,6,7,7,8,8};
		System.out.println("Number of 0s = " + count(array));
	}
	
	@Test
	public void test() {
		int[] array = {-5,-3,-1,0,0,0,0,0,0,0,1,2,3,4,5,6,6,7,7,8,8};
		Assert.assertTrue(count(array) == 7);
		
	}
	
	// the count will be (lastIndexOccur - firstIndexOccur) + 1
		private static int count(int[] array) {
						
			// find the first occurrence index 
			int i = first(array, 0, array.length - 1, 0);
			if(i == -1) return 0;

			// find the last occurrence index
			int j = last(array, 0, array.length - 1, 0);
			
			return (j - i) + 1;
		}
	
	// find the first occurrence index of the search number
	static int first(int arr[], int low, int high,int number) {
		
		int arrayLength = arr.length;
		
		if (high >= low) {
			int mid = (low + high) / 2;
			
			if ((mid == arrayLength - 1 || number  > arr[mid -1]) && arr[mid] == number ) // if it founds return the mid value
				return mid;
			
			if (number > arr[mid])  
				return first(arr, mid+1, high, number); // the number  is larger than the mid point value
			else					
				return first(arr, low, mid-1, number); // the number  is smaller than the mid point value
		}
		return -1;
	}

	// find the last occurrence index of the search number
	static int last(int arr[], int low, int high,int number ) {

		int arrayLength = arr.length;
		
		if (high >= low) {
			int mid = (low + high) / 2;
			
			if ((mid == arrayLength- 1 || number  < arr[mid + 1]) && arr[mid] == number ) // if it founds return the mid value
				return mid;
			
			if (number < arr[mid])  
				return last(arr, low, (mid - 1), number); // the number  is smaller than the mid point value
			else					
				return last(arr, (mid + 1), high, number); // the number  is larger than the mid point value
		}
		return -1;
	}

	

}
