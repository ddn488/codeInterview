package coding;

import java.util.PriorityQueue;


class Patient implements Comparable<Patient> {
	int age;
	
	Patient(int age) {
		this.age =age;
	}

	@Override
	public int compareTo(Patient o) {

		return o.age > this.age ? 1 : o.age < this.age ? -1 : 0;
	}

}

public class PriorityQueueSample {

	public static void main(String[] args) {
		PriorityQueue<Patient> queue = new PriorityQueue<Patient>();
		 queue.add(new Patient(70));
		 queue.add(new Patient(20));
		 queue.add(new Patient(10));
		 queue.add(new Patient(60));
		 queue.add(new Patient(50));
		 
		 System.out.println("Older patient pripority queue:");
		 while(!queue.isEmpty()) {
			 Patient p = queue.remove();
			 System.out.println(p.age);
		 }
	}

}
