package codeInterview;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

// PIMCO test

interface IObjectTest {
	boolean test(Object o);
}

class TestObject {
	Boolean value;

	TestObject(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}
}

class FilteringIterator {

	static List<Object> filter(@SuppressWarnings("rawtypes") Iterator myIterator, IObjectTest myTest) {
		List<Object> list = new ArrayList<Object>();
		
		while (myIterator.hasNext()) {
			Object o = myIterator.next();
			if (myTest.test(o)) {
				list.add(o);
			}
		}

		return list;
	}
}

public class MyFilter {

	@Test
	public void testFilter() {

		List<TestObject> testArray = new ArrayList<TestObject>();

		testArray.add(new TestObject(true));
		testArray.add(new TestObject(false));
		testArray.add(new TestObject(true));
		

		List<Object> filteredList = FilteringIterator.filter(testArray.iterator(), o -> {
			return ((TestObject) o).value;

		});

		assertEquals(2, filteredList.size());

	}
}
