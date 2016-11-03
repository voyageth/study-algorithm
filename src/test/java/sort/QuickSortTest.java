package sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-03
 */
public class QuickSortTest {
	@Test
	public void test() {
		int[] input = null;
		QuickSort.sortAsc(input);
		Assert.assertArrayEquals(null, input);
		input = new int[] {};
		QuickSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {}, input);
		input = new int[] {1};
		QuickSort.sortAsc(input);
		Assert.assertArrayEquals(new int[] {1}, input);
		System.out.println("-------------------");

		input = new int[] {3, 2, 5, 23, 324, 46, 234, 1};
		QuickSort.sortAsc(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);

		System.out.println("-------------------");
		input = new int[] {1, 2, 3, 5, 23, 46, 234, 324};
		QuickSort.sortAsc(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);

		System.out.println("-------------------");
		input = new int[] {324, 234, 46, 23, 5, 3, 2, 1};
		QuickSort.sortAsc(input);
		System.out.println(Arrays.toString(input));
		Assert.assertArrayEquals(new int[] {1, 2, 3, 5, 23, 46, 234, 324}, input);
	}
}