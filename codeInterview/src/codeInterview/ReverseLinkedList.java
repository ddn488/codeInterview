package codeInterview;

import java.util.LinkedList;
import java.util.List;

import org.junit.*;

public class ReverseLinkedList {

	@Test
	public void testReverse() {
		List<String> test = new LinkedList<String>();
		test.add("I ");
		test.add("am ");
		test.add("Dennis ");
		test.add("Nguyen ");
		
		Assert.assertTrue(test.toString().equals("[I , am , Dennis , Nguyen ]"));
		
		test = reverse(test);

		Assert.assertTrue(test.toString().equals("[Nguyen , Dennis , am , I ]"));
	}

	public List<String> reverse(List<String> linkedList) {

		if (linkedList == null)
			return null;
		if (linkedList.size() <= 1)
			return linkedList;

		List<String> result = new LinkedList<String>();
		int i = linkedList.size() - 1;

		while (i >= 0) {
			result.add(linkedList.get(i));
			i--;
		}
		return result;
	}
}

