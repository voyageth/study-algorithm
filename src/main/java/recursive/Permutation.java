package recursive;

/**
 * @author voyageth
 *         2016-11-08
 */
public class Permutation {
	/**
	 * @param string input string. assume ascii.
	 */
	public void permute(String string) {
		if (string == null || string.length() == 0) {
			return;
		}

		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int[] usedIndex = new int[chars.length];
			for (int j = 0; j < usedIndex.length; j++) {
				usedIndex[j] = -1;
			}
			usedIndex[i] = 0;
			permute(chars, usedIndex, 1);
			usedIndex[i] = -1;
		}
	}

	private void permute(char[] chars, int[] usedIndex, int level) {
		if (chars.length <= usedCount(usedIndex)) {
			int[] newIndex = new int[usedIndex.length];
			for (int i = 0; i < usedIndex.length; i++) {
				newIndex[usedIndex[i]] = i;
			}
			for (int i = 0; i < newIndex.length; i++) {
				System.out.print(chars[newIndex[i]]);
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < chars.length; i++) {
			if (usedIndex[i] >= 0) {
				continue;
			}

			usedIndex[i] = level;
			permute(chars, usedIndex, level + 1);
			usedIndex[i] = -1;
		}
	}

	private int usedCount(int[] usedIndex) {
		int count = 0;
		for (int i = 0; i < usedIndex.length; i++) {
			if (usedIndex[i] >= 0) {
				count++;
			}
		}
		return count;
	}
}
