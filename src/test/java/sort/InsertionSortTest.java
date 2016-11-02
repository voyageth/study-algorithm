package sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-02
 */
public class InsertionSortTest {
	@Test
	public void test() {
		int[] input = null;
		InsertionSort.sortAsc(input);
		Assert.assertArrayEquals(null, input);
		input = new int[] {};
		InsertionSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {}, input);
		input = new int[] {1};
		InsertionSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {1}, input);
		input = new int[] {3, 2, 5, 23, 324, 46, 234, 1};
		InsertionSort.sortAsc(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);
	}

	@Test
	public void sortedTest() {
		int[] input = null;
		input = new int[] {1, 2, 3, 5, 23, 46, 234, 324};
		InsertionSort.sortAsc(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);
	}
}