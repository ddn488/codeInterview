package codeInterview.practice;

import java.util.LinkedList;

/**
 * Merge two sorted node lists
 * 
 * http://algorithmsandme.in/2013/10/merge-two-sorted-linked-lists-in-one-list/#.VQkTTfmUfA0
 * 
 * The key to solve the problem is defining a fake head. Then compare the first elements from each list.
 *  Add the smaller one to the merged list.
 *  Finally, when one of them is empty, simply append it to the merged list, since it is already sorted
 * 
 * 
 *
 */
public class MergeSortedLinkList {

	public static void main(String[] args) {
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node5 = new Node(5);
		
		node1.next = node2;
		node2.next = node5;
		
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		
		node3.next=node4;
		node4.next=node7;
	

		Node mergeNode = mergeList(node1, node3);
		
		mergeNode.printAll();
		
	}

	static Node mergeList(Node l1, Node l2) {

		Node head = new Node(0);

		Node p = head; // p is "iterative node"

		while (l1 != null || l2 != null) {

			if (l1 != null && l2 != null) {
				
				if (l1.data < l2.data) {
					p.next = l1;
					l1 = l1.next;
				} else {
					p.next = l2;
					l2 = l2.next;
				}
				
				p = p.next;

			} else if (l1 == null) { // case l1==null but l2 != null then p =l2 !done.
				p.next = l2;
				
				break;
			} else if (l2 == null) {  // case l1!=null but l2 == null then p =l1 !done.
				p.next = l1;
				break;
			}

		}

		return head.next;

	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	void printAll() {
		Node it = this;
		while(it.next != null) {
			System.out.print(it.data + " ");
			it = it.next;
		}
		
		System.out.print(it.data + " ");
	}
}