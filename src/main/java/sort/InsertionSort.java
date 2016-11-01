package sort;

/**
 * @author voyageth
 *         2016-11-02
 */
public class InsertionSort {
	public static void sortAsc(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}

		for (int i = 0; i < array.length; i++) {
			int currentValue = array[i];
			for (int j = 0; j < i; j++) {
				if (currentValue < array[j]) {
					System.arraycopy(array, j, array, j + 1, i - j);
					array[j] = currentValue;
					break;
				}
			}
		}
	}
}
