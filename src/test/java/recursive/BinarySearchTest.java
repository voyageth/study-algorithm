package recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-08
 */
public class BinarySearchTest {
	@Test
	public void iterTest() {
		BinarySearch binarySearch = new BinarySearch();
		int[] ascSortedArray = new int[] {1, 2, 5, 6, 7, 8, 25, 436, 2345, 5436, 234235, 547463};
		for (int i = 0; i < ascSortedArray.length; i++) {
			Assert.assertEquals(i, binarySearch.findIndexIter(ascSortedArray, ascSortedArray[i]));
		}
		Assert.assertEquals(-1, binarySearch.findIndexIter(ascSortedArray, -235325));
		Assert.assertEquals(-1, binarySearch.findIndexIter(ascSortedArray, 10));
		Assert.assertEquals(-1, binarySearch.findIndexIter(ascSortedArray, 1034543346));
	}

	@Test
	public void recTest() {
		BinarySearch binarySearch = new BinarySearch();
		int[] ascSortedArray = new int[] {1, 2, 5, 6, 7, 8, 25, 436, 2345, 5436, 234235, 547463};
		for (int i = 0; i < ascSortedArray.length; i++) {
			Assert.assertEquals(i, binarySearch.findIndexRec(ascSortedArray, 0, ascSortedArray.length, ascSortedArray[i]));
		}
		Assert.assertEquals(-1, binarySearch.findIndexRec(ascSortedArray, 0, ascSortedArray.length, -235325));
		Assert.assertEquals(-1, binarySearch.findIndexRec(ascSortedArray, 0, ascSortedArray.length, 10));
		Assert.assertEquals(-1, binarySearch.findIndexRec(ascSortedArray, 0, ascSortedArray.length, 1034543346));
	}
}