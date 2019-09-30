import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class StudentTest {

	public static final double TOLERANCE = 0.0001;

	// testing on getters
	@Test
	public void test1() {
		int[] ziboMarks = { 70, 70, 70, -1, 70, 80, 70, 65, 50, 69, 70, 40, 70, 55 };
		Student zibo = new Student("000855446", ziboMarks);

		String expectedRegistrationNumber = "000855446";
		int[] expectedMarks = { 70, 70, 70, -1, 70, 80, 70, 65, 50, 69, 70, 40, 70, 55 };

		String actualRegistrationNumber = zibo.getRegistrationNumber();
		int[] actualMarks = zibo.getMarks();

		assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
		assertTrue(Arrays.equals(expectedMarks, actualMarks));
	}

	// testing on setters
	@Test
	public void test2() {
		int[] ziboMarks = { 70, 70, 70, -1, 70, 80, 70, 65, 50, 69, 70, 40, 70, 55 };
		Student zibo = new Student("000855446", ziboMarks);

		zibo.setRegistrationNumber("000855446");
		zibo.setAssignmentMark(4, 60);

		String expectedRegistrationNumber = "000855446";
		int[] expectedMarks = { 70, 70, 70, 60, 70, 80, 70, 65, 50, 69, 70, 40, 70, 55 };

		String actualRegistrationNumber = zibo.getRegistrationNumber();
		int[] actualMarks = zibo.getMarks();

		assertEquals(expectedRegistrationNumber, actualRegistrationNumber);
		assertTrue(Arrays.equals(expectedMarks, actualMarks));
	}

	@Test
	// testing on total mark and passed condition
	public void test3() {
		int[] jayonMarks = { 50, 53, 67, 54, 80, 50, 50, 50, 67, 50, 50, 50, -1, 67 };
		Student jayon = new Student("123456789", jayonMarks);

		double expectedTotalMarkJayon = 64.5;

		double actualTotalMarkJayon = jayon.totalMark();

		assertEquals(expectedTotalMarkJayon, actualTotalMarkJayon, TOLERANCE);

		assertTrue(jayon.passed());
	}

	@Test
	// testing on insufficient marks
	public void test4() {
		int[] tomMarks = { 50, 67, 50, 54, 76, 50, 34, 50, 67, 50, 50, 50, -1, -1 };
		Student tom = new Student("666666", tomMarks);

		double expectedTotalMark = -1;

		double actualTotalMark = tom.totalMark();

		assertEquals(expectedTotalMark, actualTotalMark, TOLERANCE);
	}

	// testing insufficient marks
	@Test(expected = IllegalArgumentException.class)
	public void test5() {

		int[] marryMarks = { 50, 60, -1, 60, 65, 70, 55, 66, 60, 73, 65, 45, 68, -1 };
		Student marry = new Student("1111114", marryMarks);

		// exception should be thrown
		marry.passed();
	}
}