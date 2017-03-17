package coding.reflection;

import org.junit.Assert;
import org.junit.Test;

// What is reflection in java and can you suggest a design pattern that can use reflection. 
// Please write pseudo-code to explain how reflection is used by the design pattern.
//
// Reflection is used by programs to examine or modify an object at runtime without knowing about the object at compile time.
//
//  Factory design pattern is common used to implement reflection and to know exactly what run-time type should be used.
//  The purpose of the factory pattern is to de-couple some code from the run-time type of an object it consumes
// 
// Assume that Sport is abstract class
// And SoccerSport and FootBallSport are subclass of Sport Class in the “coding.reflection” package

abstract class Sport {
	public abstract String toString();
}

class SoccerSport extends Sport {
	public String toString() {
		return "I like SoccerSport";
	}
}

class FootBallSport extends Sport {
	public String toString() {
		return "I like FootBallSport";
	}
}

public class ReflectionFactoryTest {
	static ReflectionFactoryTest instance;

	@Test
	public void testCreateSportInstance()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Sport soccerSport = ReflectionFactoryTest.getInstance().createSportInstance("SoccerSport");
		Assert.assertTrue("I like SoccerSport".equals(soccerSport.toString()));

		Sport footBallSport = ReflectionFactoryTest.getInstance().createSportInstance("FootBallSport");
		Assert.assertTrue("I like FootBallSport".equals(footBallSport.toString()));
	}

	public static ReflectionFactoryTest getInstance() {
		synchronized (ReflectionFactoryTest.class) {
			if (instance == null) {
				instance = new ReflectionFactoryTest();
			}
			return instance;
		}

	}

	public Sport createSportInstance(String name)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("coding.reflection." + name);
		return (Sport) clazz.newInstance();
	}
}
