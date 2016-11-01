package sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-02
 */
public class SelectionSortTest {
	@Test
	public void test() {
		int[] input = null;
		SelectionSort.sortAsc(input);
		Assert.assertArrayEquals(null, input);
		input = new int[] {};
		SelectionSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {}, input);
		input = new int[] {1};
		SelectionSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {1}, input);
		input = new int[] {3, 2, 5, 23, 324, 46, 234, 1};
		SelectionSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);
	}

	@Test
	public void recTest() {
		int[] input = null;
		SelectionSort.sortAscRec(input);
		Assert.assertArrayEquals(null, input);
		input = new int[] {};
		SelectionSort.sortAscRec(input);
		Assert.assertArrayEquals(new int[] {}, input);
		input = new int[] {1};
		SelectionSort.sortAscRec(input);
		Assert.assertArrayEquals(new int[] {1}, input);
		input = new int[] {3, 2, 5, 23, 324, 46, 234, 1};
		SelectionSort.sortAscRec(input);
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);
	}
}