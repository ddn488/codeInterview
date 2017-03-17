package coding;

import org.junit.Assert;
import org.junit.Test;

enum SportField {
	BASEBALL, SOCCER, FOOTBALL;

	String member;
	int length;
	int width;

	int calculateArea() {
		return length * width;
	}
}

public class EnumTest {

	@Test
	public void testCalculateArea() {
		SportField.SOCCER.member = "Soccer Field";
		SportField.SOCCER.length = 5;
		SportField.SOCCER.width = 5;
		Assert.assertTrue(SportField.SOCCER.member == "Soccer Field");
		Assert.assertTrue(SportField.SOCCER.calculateArea() == 25);

		SportField.BASEBALL.member = "Baseball Field";
		SportField.BASEBALL.length = 3;
		SportField.BASEBALL.width = 5;
		Assert.assertTrue(SportField.BASEBALL.member == "Baseball Field");
		Assert.assertTrue(SportField.BASEBALL.calculateArea() == 15);
	}
}
