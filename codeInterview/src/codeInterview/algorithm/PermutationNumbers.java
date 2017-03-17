package codeInterview.algorithm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationNumbers {
	
	@Test
	public void testPermute() {
		int[] numbers = {1,2,3};
		List<List<Integer>> permutations = permute(numbers);
		
		permutations.forEach(list -> {
			list.forEach( i -> {
				System.out.print(i + " ");
			});
			System.out.println();
		});
		
	}
	
	public List<List<Integer>> permute(int[] numbers) {
	    
	    List<List<Integer>> permutations = new ArrayList<List<Integer>>(); 
	    // Add an empty list so that the middle for loop runs
	    permutations.add(new ArrayList<Integer>());
	
	    for ( int i = 0; i < numbers.length; i++ ) {
	        
	        List<List<Integer>> current = new ArrayList<List<Integer>>();
	        
	        for ( List<Integer> permutation : permutations ) {
	        	int n = permutation.size() + 1;
	            for ( int j = 0 ; j < n; j++ ) {
	                List<Integer> temp = new ArrayList<Integer>(permutation);
	                temp.add(j, numbers[i]);
	                current.add(temp);
	            }
	        }
	        permutations = new ArrayList<List<Integer>>(current);
	    }
	
	    return permutations;
	}
}

