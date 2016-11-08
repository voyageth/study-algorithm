package recursive;

/**
 * @author voyageth
 *         2016-11-08
 */
public class BinarySearch {
	public int findIndexIter(int[] ascSortedArray, int value) {
		if (ascSortedArray == null || ascSortedArray.length <= 0) {
			return -1;
		}

		int startIndex = 0;
		int endIndex = ascSortedArray.length;
		while (startIndex < endIndex) {
			int midIndex = startIndex + (endIndex - startIndex) / 2;
			int midValue = ascSortedArray[midIndex];
			if (midValue == value) {
				return midIndex;
			} else if (value < midValue) {
				endIndex = midIndex;
			} else {
				startIndex = midIndex + 1;
			}
		}
		if (startIndex < ascSortedArray.length) {
			if (ascSortedArray[startIndex] == value) {
				return startIndex;
			}
		}

		return -1;
	}

	public int findIndexRec(int[] ascSortedArray, int startIndex, int endIndex, int value) {
		if (ascSortedArray == null || ascSortedArray.length <= 0) {
			return -1;
		}
		if (startIndex < 0 || startIndex >= ascSortedArray.length) {
			return -1;
		}
		if (endIndex <= 0 || endIndex > ascSortedArray.length) {
			return -1;
		}
		if (startIndex == endIndex) {
			return -1;
		}

		int midIndex = startIndex + ((endIndex - startIndex) / 2);
		int midValue = ascSortedArray[midIndex];
		if (midValue == value) {
			return midIndex;
		} else if (value < midValue) {
			return findIndexRec(ascSortedArray, startIndex, midIndex, value);
		} else {
			return findIndexRec(ascSortedArray, midIndex + 1, endIndex, value);
		}
	}
}
