package coding;

import java.awt.datatransfer.StringSelection;

/*	Input:
		  First List: 7->5->9->4->6  // represents number 64957
		  Second List: 8->4 //  represents number 48
		Output
		  Resultant list: 5->0->0->5->6  // represents number 65005
		  
		  To add two numbers: 64957 and 48 represent in two linkedlist
		  - Add numbers to LinkedListNode from the back to front
		  - loop thu both first and second then add the values 
		  
*/
class LinkedListNode {
	LinkedListNode next;
	int value;

	LinkedListNode(int value) {
		this.value = value;
		this.next = null;
	}

	static LinkedListNode sum(LinkedListNode first, LinkedListNode second) {
		LinkedListNode result = null, temp = null, prev = null;
		int carry = 0, sum;

		while (first != null || second != null) {

			sum = carry + (first != null ? first.value : 0) + (second != null ? second.value : 0);
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;

			// save temp value
			temp = new LinkedListNode(sum);

			if (result == null) { // first time
				result = temp;
			} else {
				prev.next = temp;
			}

			prev = temp;

			if (first != null)
				first = first.next;
			if (second != null)
				second = second.next;
		}

		if (carry > 0) {
			temp.next = new LinkedListNode(carry);
		}

		return result;
	}

	static String print(LinkedListNode head) {
		StringBuilder b = new StringBuilder();
		while (head != null) {
			b.append(head.value);
			head = head.next;
		}
		return b.toString();
	}

	static String printValue(LinkedListNode node) {
		String v = print(node);
		return new StringBuilder(v).reverse().toString();
	}

}

public class Sum2LinkedList {

	public static void main(String[] args) {

		// creating First List: 7->5->9->4->6 // represents number 64957
		LinkedListNode first = new LinkedListNode(7);
		first.next = new LinkedListNode(5);
		first.next.next = new LinkedListNode(9);
		first.next.next.next = new LinkedListNode(4);
		first.next.next.next.next = new LinkedListNode(6);
		System.out.println("First List is "+ LinkedListNode.print(first) + " - " + LinkedListNode.printValue(first));

		// creating Second List: 8->4 // represents number 48
		LinkedListNode second = new LinkedListNode(8);
		second.next = new LinkedListNode(4);
		System.out.println("Second List is " + LinkedListNode.print(second) + " - " + LinkedListNode.printValue(second));
		
		LinkedListNode sum = LinkedListNode.sum(first, second);
		System.out.println("Sum of first List and second is " + LinkedListNode.print(sum));
		System.out.println("Represent number: "+ LinkedListNode.printValue(sum));
		// Resultant list: 5->0->0->5->6 // represents number 65005
	}

}
