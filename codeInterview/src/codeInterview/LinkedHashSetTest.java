package codeInterview;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  LinkedHashSet keep the order of insertion the same as before
 *  
 *  while HashSet is not gurantee the order
 * 
 * @author dennis
 *
 */

class LinkedHashSetTest {

	public static void main(String[] args) {
		Set<Dog> dogs = new LinkedHashSet<Dog>();
		dogs.add(new Dog(5));
		dogs.add(new Dog(6));
		dogs.add(new Dog(2));
		dogs.add(new Dog(4));
		dogs.add(new Dog(1));

		dogs.forEach(dog -> {
			System.out.println(dog.toString());
		});
		
		// The result output is : 5 6 2 4 1
	}
}