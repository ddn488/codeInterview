package coding;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//As an example, consider a list of the Patient class from earlier in the book. We may want to group all the Patient instances 
//together where the firstName is equal – this could be achieved as follows:
//

public class UseStreamCollect {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person(" Albert", "Smith"), new Person(" John", "James"),
				new Person(" John", "Brown"), new Person(" William", "Hughes"), new Person(" William", "Fleming"));

		Map<String, List<Person>> groupedMap = people.stream().collect(Collectors.groupingBy(Person::getFirstName));

		StringBuilder b = new StringBuilder();
		groupedMap.get(" William").forEach(p -> {
			b.append(p.toString() + "\n");
		});
		
		System.out.println(b.toString());
	}
}

class Person {
	String firstName;
	String lastName;

	Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {

		return firstName + " " + lastName;
	}

}
