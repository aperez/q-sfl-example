package qsfl.example;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private static double DELTA = 10e-5;
	Calculator c = null;

	@Before
	public void before() {
		c = new Calculator();
	}

	@Test
	public void testAdd1() {
		assertEquals(c.add(2, 2), 4, DELTA);
	}

	@Test
	public void testAdd2() {
		assertEquals(c.add(1, 4), 5, DELTA);
	}

	@Test
	public void testSub1() {
		assertEquals(c.sub(0, 0), 0, DELTA);
	}

	@Test
	public void testSub2() {
		assertEquals(c.sub(4, 5), -1, DELTA);
	}

}
