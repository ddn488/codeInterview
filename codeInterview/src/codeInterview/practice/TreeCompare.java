package codeInterview.practice;

public class TreeCompare {

	/* Given two binary trees find if they are equal */
	
	public static void main(String[] args) {
		TNode left = new TNode(5, null, null);
		TNode right =  new TNode(6, null, null);
		TNode t1 = new TNode(2,left, right);
		TNode t2 = new TNode(2,left,right);
		
		if(isTreeSame(t1, t2)) System.out.println("t1 is the same as  t2");
		else System.out.println("t1 is not the same as t2");
	}
	
	static boolean isTreeSame(TNode t1, TNode t2) {
		if(t1 == null && t2 == null) return true;
		
		if(t1 == null || t2 == null) return false;
		
		if(t1.data != t2.data) return false;
		
		return isTreeSame(t1.left,t2.left) && isTreeSame(t1.right, t2.right);
		
	}

}

class TNode {
	int data;
	TNode left, right;
	
	TNode(int data, TNode left, TNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}
