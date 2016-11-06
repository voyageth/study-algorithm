package sort;

/**
 * @author voyageth
 *         2016-11-03
 */
public class QuickSort {
	public static void sortAsc(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		sortAscRec(array, 0, array.length - 1);
	}

	private static void sortAscRec(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex || endIndex < 0) {
			return;
		}

		int midValue = array[(startIndex + endIndex) / 2];
		int leftIndex = startIndex;
		int rightIndex = endIndex;

		while (leftIndex <= rightIndex) {
			while (array[leftIndex] < midValue) {
				leftIndex++;
			}

			while (array[rightIndex] > midValue) {
				rightIndex--;
			}

			if (leftIndex <= rightIndex) {
				swap(array, leftIndex, rightIndex);
				leftIndex++;
				rightIndex--;
			}
		}

		if (startIndex < rightIndex) {
			sortAscRec(array, startIndex, rightIndex);
		}
		if (leftIndex < endIndex) {
			sortAscRec(array, leftIndex, endIndex);
		}
	}

	private static void swap(int[] array, int index1, int index2) {
		if (index1 != index2) {
			int tempValue = array[index1];
			array[index1] = array[index2];
			array[index2] = tempValue;
		}
	}
}
