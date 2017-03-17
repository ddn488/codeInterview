package coding;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet implement Set interface with sorting on the object. therefore the
 * object must implement Comparable interface
 * 
 * Performance: TreeSet is slowest compared with HashSet and LinkedHashSet due to the sorting 
 * 
 * @author dennis
 *
 */
class Dog implements Comparable<Dog> {
	int size;

	public Dog(int s) {
		size = s;
	}

	public String toString() {
		return size + "";
	}

	// IMPORTANT FOR TreeSet
	@Override
	public int compareTo(Dog o) {
		return size - o.size;
	}
}

class TreeSetTest {

	public static void main(String[] args) {
		Set<Dog> dogs = new TreeSet<Dog>();

		dogs.add(new Dog(5));
		dogs.add(new Dog(6));
		dogs.add(new Dog(2));
		dogs.add(new Dog(4));
		dogs.add(new Dog(1));

		dogs.forEach(dog -> {
			System.out.println(dog.toString());
		});

		dogs = new LinkedHashSet<Dog>();
		dogs.add(new Dog(5));
		dogs.add(new Dog(6));
		dogs.add(new Dog(2));
		dogs.add(new Dog(4));
		dogs.add(new Dog(1));

		dogs.forEach(dog -> {
			System.out.println(dog.toString());
		});

	}

}
