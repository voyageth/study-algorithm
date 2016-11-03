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

		sortAscRec(array, 0, array.length);
	}

	private static void sortAscRec(int[] array, int startIndex, int endIndex) {
		if (startIndex >= endIndex || endIndex == 0) {
			return;
		}

		int midIndex = startIndex + (endIndex - startIndex) / 2;
		int midValue = array[midIndex];
		int leftIndex = startIndex;
		int rightIndex = endIndex - 1;

		while (leftIndex < rightIndex) {
			for (int i = leftIndex; i < rightIndex; i++) {
				if (array[i] < midValue) {
					swap(array, i, leftIndex);
					leftIndex++;
				} else {
					swap(array, i, rightIndex);
					if (i == midIndex) {
						midIndex = rightIndex;
					} else if (rightIndex == midIndex) {
						midIndex = i;
					}
					rightIndex--;
				}
			}
		}

		if (array[leftIndex] < midValue) {
			swap(array, leftIndex + 1, midIndex);
			sortAscRec(array, startIndex, leftIndex + 1);
			sortAscRec(array, leftIndex + 2, endIndex);
		} else {
			swap(array, leftIndex, midIndex);
			sortAscRec(array, startIndex, leftIndex);
			sortAscRec(array, leftIndex + 1, endIndex);
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
