package sort;

/**
 * @author voyageth
 *         2016-11-04
 */
public class MergeSort {
	public static int[] sortAsc(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}

		int mid = array.length / 2;

		int[] left = new int[mid];
		int[] right = new int[array.length - mid];

		System.arraycopy(array, 0, left, 0, left.length);
		System.arraycopy(array, mid, right, 0, right.length);

		sortAsc(left);
		sortAsc(right);

		merge(array, left, right);

		return array;
	}

	private static void merge(int[] destination, int[] left, int[] right) {
		int destinationIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				destination[destinationIndex++] = left[leftIndex++];
			} else {
				destination[destinationIndex++] = right[rightIndex++];
			}
		}
		while (leftIndex < left.length) {
			destination[destinationIndex++] = left[leftIndex++];
		}
		while (rightIndex < right.length) {
			destination[destinationIndex++] = right[rightIndex++];
		}
	}
}
