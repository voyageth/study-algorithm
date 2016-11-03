package sort;

/**
 * @author voyageth
 *         2016-11-02
 */
public class SelectionSort {
	public static void sortAscRecStable(int[] array) {
		sortAscRecStable(array, 0);
	}

	private static void sortAscRecStable(int[] array, int startIndex) {
		if (array == null || array.length <= 0) {
			return;
		}

		if (startIndex <= array.length - 1) {
			insert(array, startIndex, findMinimumIndex(array, startIndex));
			sortAscRecStable(array, startIndex + 1);
		}
	}

	private static void insert(int[] array, int startIndex, int minIndex) {
		if (minIndex > startIndex) {
			int temp = array[minIndex];
			System.arraycopy(array, startIndex, array, startIndex + 1, minIndex - startIndex);
			array[startIndex] = temp;
		}
	}

	public static void sortAscRec(int[] array) {
		sortAscRec(array, 0);
	}

	private static void sortAscRec(int[] array, int startIndex) {
		if (array == null || array.length <= 0) {
			return;
		}

		if (startIndex <= array.length - 1) {
			swap(array, startIndex, findMinimumIndex(array, startIndex));
			sortAscRec(array, startIndex + 1);
		}
	}

	private static void swap(int[] array, int firstIndex, int secondIndex) {
		if (firstIndex != secondIndex) {
			int temp = array[firstIndex];
			array[firstIndex] = array[secondIndex];
			array[secondIndex] = temp;
		}
	}

	private static int findMinimumIndex(int[] array, int startIndex) {
		int minimumIndex = startIndex;
		for (int i = startIndex; i < array.length; i++) {
			if (array[i] < array[minimumIndex]) {
				minimumIndex = i;
			}
		}
		return minimumIndex;
	}

	public static void sortAsc(int[] array) {
		if (array == null) {
			return;
		}
		if (array.length <= 0) {
			return;
		}

		for (int i = 0; i < array.length; i++) {
			int tempValue = array[i];
			int tempIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (tempValue > array[j]) {
					tempIndex = j;
					tempValue = array[j];
				}
			}
			if (tempIndex != i) {
				tempValue = array[tempIndex];
				array[tempIndex] = array[i];
				array[i] = tempValue;
			}
		}
	}
}
