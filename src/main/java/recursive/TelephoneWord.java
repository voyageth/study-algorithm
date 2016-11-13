package recursive;

/**
 * @author voyageth
 *         2016-11-10
 */
public class TelephoneWord {
	public TelephoneWord() {
	}

	public void printAvailableWordsRec(int[] numbers) {
		printAvailableWordsRec(numbers, 0, new StringBuilder());
	}

	public void printAvailableWordsRec(int[] numbers, int index, StringBuilder sb) {
		for (int i = 1; i <= 3; i++) {
			char key = getCharKey(numbers[index], i);
			sb.append(key);
			if (index == numbers.length - 1) {
				System.out.println(sb);
			} else {
				printAvailableWordsRec(numbers, index + 1, sb);
			}
			sb.setLength(sb.length() - 1);

			if (key == (char)('0' + numbers[index])) {
				break;
			}
		}
	}

	char getCharKey(int telephoneKey, int place) {
		if (telephoneKey < 2 || telephoneKey > 9 || place < 1 || place > 3) {
			return (char)('0' + telephoneKey);
		}

		if (telephoneKey == 7) {
			switch (place) {
				case 1:
					return 'P';
				case 2:
					return 'R';
				case 3:
					return 'S';
				default:
					return (char)('0' + telephoneKey);
			}
		} else if (telephoneKey < 7) {
			return (char)('A' + ((telephoneKey - 2) * 3) + (place - 1));
		} else {
			return (char)('T' + ((telephoneKey - 8) * 3) + (place - 1));
		}
	}
}
