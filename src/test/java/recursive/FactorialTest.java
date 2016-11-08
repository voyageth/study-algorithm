package recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-08
 */
public class FactorialTest {
	@Test
	public void allFactorialTest() {
		Factorial factorial = new Factorial();
		Assert.assertArrayEquals(new int[] {3628800, 362880, 40320, 5040, 720, 120, 24, 6, 2, 1}, factorial.allFactorial(10));
	}

	@Test
	public void factorialRecTest() {
		Factorial factorial = new Factorial();
		Assert.assertEquals(24, factorial.factorialRec(4));
		Assert.assertEquals(120, factorial.factorialRec(5));
		Assert.assertEquals(720, factorial.factorialRec(6));
		Assert.assertEquals(5040, factorial.factorialRec(7));
	}

	@Test
	public void factorialIterTest() {
		Factorial factorial = new Factorial();
		Assert.assertEquals(24, factorial.factorialIter(4));
		Assert.assertEquals(120, factorial.factorialIter(5));
		Assert.assertEquals(720, factorial.factorialIter(6));
		Assert.assertEquals(5040, factorial.factorialIter(7));
	}
}