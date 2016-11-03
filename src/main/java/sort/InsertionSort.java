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

		for (int i = 1; i < array.length; i++) {
			int currentValue = array[i];
			for (int j = i - 1; j >= 0; j--) {
				if (currentValue < array[j]) {
					// array[j+1] value is always equals to currentValue.
					array[j + 1] = array[j];
					array[j] = currentValue;
				} else {
					break;
				}
			}
		}
	}
}
