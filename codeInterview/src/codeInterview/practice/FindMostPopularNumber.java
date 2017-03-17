package codeInterview.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Given a sorted array of integers find the integer with the greatest number of repetition. e.g: 
 * input: 1, 1, 1, 4, 4, 4, 4, 5, 6
 *  output: 4
*/
public class FindMostPopularNumber {

	public static void main(String[] args) {
		
		int[] arr = {1, 1, 1, 1,1, 4, 4, 4, 4, 5,5,5,5,5,5,5,5, 6};
		
		System.out.println(findGreatestNumberRepeat(arr));
	}
	
	static int findGreatestNumberRepeat(int[] arr) {
		int greatestNumber = 0;
		
		int element=0;
		int count=0;
		int maxCount=0;
		int elementWithMaxCount=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == element) {
				count++;
			} else { // change to the next number
				count = 1;
				element = arr[i];
			}
			
			if(count > maxCount) {
				maxCount = count;
				elementWithMaxCount = arr[i];
				
			}
		}		
		return elementWithMaxCount;
	}
}
