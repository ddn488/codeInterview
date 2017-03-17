package coding;

//code for merge sort implementation using linked lists.
//
//Procedure:
//
//MergeSort(head node)
//
//1) If head is NULL or there is only one element in the Linked List then return the node.
//2) Else divide the linked list into two halves a and b.
//3) Sort recursively the two halves a and b
//4) Merge the sorted a and b
//5) append the head to the remaining merged list.

//How Merge Sort works 
//Merge Sort works by breaking the linked list(or Array) into 2 equal parts say Left half and Right half.
//Again break 2 list that we got in Step 1 in two equal parts each.  
//Repeat above steps until only 1 element remains in Linked list (or Array) because list with only 1 element is always sorted. 
//So in each step we are breaking the list in Left half and Right half.  
//When complete list is divided and contains only Single element in Left and Right half each, Start comparing and sorting each Left and Right half, So that portion of Linked list will be sorted.
//Repeat Step 5 for all the remaining Left and Right half and complete linked list will be sorted.
//It works on divide and conquer technique. Time complexity is O(N log N).



public class MergeSortLinkedList {

	public static void main(String[] args) {
		LinkedList object = new LinkedList();
		object.insert(30);
		object.insert(10);
		object.insert(50);
		object.insert(20);
		object.insert(5);
		object.insert(8);
		object.display();
		System.out.println("The list after merge sort O(nlog(n))");
		object.append(object.mergeSort(object.extractFirst()));
		object.display();
	}
}

class Node {
	public int item;
	public Node next;

	public Node(int val) {
		item = val;
	}

	public Node() {
	}

	public void displayNode() {
		System.out.println("[" + item + "] ");
	}
}

class LinkedList {
	private Node first;

	public LinkedList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insert(int val)// inserts at beginning of list
	{
		Node newNode = new Node(val);
		newNode.next = first;
		first = newNode;
	}

	public void append(Node result) {
		first = result;
	}

	public void display() {
		System.out.println("List items from first to last :");
		Node current = first;
		while (current != null) {
			current.displayNode();
			current = current.next;
		}
		System.out.println("");
	}

	public Node extractFirst() {
		return first;
	}

	public Node mergeSort(Node headOriginal) {
		if (headOriginal == null || headOriginal.next == null)
			return headOriginal;
		Node a = headOriginal;
		Node b = headOriginal.next;
		while ((b != null) && (b.next != null)) {
			headOriginal = headOriginal.next;
			b = (b.next).next;
		}
		b = headOriginal.next;
		headOriginal.next = null;
		return merge(mergeSort(a), mergeSort(b));

	}

	public Node merge(Node a, Node b) {
		Node temp = new Node();
		Node head = temp;
		Node c = head;
		while ((a != null) && (b != null)) {
			if (a.item <= b.item) {
				c.next = a;
				c = a;
				a = a.next;
			} else {
				c.next = b;
				c = b;
				b = b.next;
			}
		}
		c.next = (a == null) ? b : a;
		return head.next;
	}
}
