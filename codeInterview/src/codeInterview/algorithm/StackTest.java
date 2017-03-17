package codeInterview.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import org.junit.*;

public class StackTest {
//	Stacks: Question
//	Write a function to determine if a string consisting of the characters '{', '}', '[', and ']' is balanced.
//	For example, "{[]}" is balanced, and "{[}]" is not.
//	
	public boolean isBalanced(String braces) {
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < braces.length(); i++) {
	        switch (braces.charAt(i)) {
	            case '{': stack.push('{');
	                break;
	            case '[': stack.push('[');
	                break;
	            case '}': if (stack.pop() != '{') { return false; }
	                break;
	            case ']': if (stack.pop() != '[') { return false; }
	                break;
	        }
	    }
	    return stack.isEmpty();
	}
	

	@Test
	public void testIsBalanced() {
		Assert.assertFalse(isBalanced(("[{}")));

		Assert.assertTrue(isBalanced(("[{}]")));
	}
	
//----------------------------------------------	
//	Queues: Question
//	Given one queue and one stack, how do you reverse the stack?
	
	public Stack<Integer> reverserStack(Stack<Integer> stack) {
		Queue<Integer> queue = new ArrayDeque<Integer>();
	    
	    // Pop all values from Stack to Queue using add() 
	    while (!stack.isEmpty()) {
	        queue.add(stack.pop());
	    }
	    // push all values to Stack  again Queue values using remove()
	    while (!queue.isEmpty()) {
	        stack.push(queue.remove());
	    }
	    
	    return stack; // [3, 2, 1]
		
	}
	
	@Test
	public void testReverserStack() {
		Stack<Integer> stack = new Stack<Integer>();
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    
	    Assert.assertTrue(stack.toString().equals("[1, 2, 3]"));
	    
	    stack = reverserStack(stack);	    
	    Assert.assertTrue(stack.toString().equals("[3, 2, 1]"));	    	    
	}

}
