package coding.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *  Write a custom Stack which accepts all generic type, for example the stack accepts all sport types like
 *  socces, football, etc..
 * 
 *
 */
public class GenericsTest {

	List<Base> list;
	
	@Before
	public void setUp() {
		list = new ArrayList<Base>();
		list.add(new Soccer());
		list.add(new Football());
	}
	
	@Test
	public void testPushAll() {
		
		CustomStack<Base> c = new CustomStack<Base>();
		c.pushAll(list);
		
		Assert.assertTrue("Football".equals(c.pop().getType()));
		Assert.assertTrue("Soccer".equals(c.pop().getType()));
	}
	
	@Test
	public void testPopAll() {
		
		CustomStack<Base> c = new CustomStack<Base>();
		c.popAll(list);
		
		Assert.assertTrue(c.isEmpty());
		
	}

}

class CustomStack<Base> extends Stack<Base> {	
	
	public void pushAll(List<? extends Base> list) {
		if(!list.isEmpty()) {
			list.forEach( e -> {
				this.push(e);
			});
		}
	}
	
	public void popAll(List<? extends Base> list) {
		if(!list.isEmpty()) {
			list.forEach( e -> {
				if(!this.isEmpty()) {
					if(this.peek().equals(e)) this.pop();	
				}
							
			});
		}
	}
}

abstract class Base {
	public abstract String getType() ;
}

class Soccer extends Base {
	@Override
	public String getType() {		
		return "Soccer";
	}	
}
class Football extends Base {
	@Override
	public String getType() {		
		return "Football";
	}	
}

