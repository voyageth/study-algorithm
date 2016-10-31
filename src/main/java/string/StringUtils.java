package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voyageth
 *         2016-10-28
 */
public class StringUtils {
	public static String reverseWords(String str) {
		if (str == null) {
			return null;
		}

		char[] charArray = str.toCharArray();
		reverseWord(charArray, 0, charArray.length);

		int wordStartIndex = 0;
		int wordEndIndex = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (' ' == charArray[i]) {
				if (wordStartIndex < wordEndIndex) {
					reverseWord(charArray, wordStartIndex, wordEndIndex);
				}
				wordStartIndex = i + 1;
				wordEndIndex = wordStartIndex;
			} else {
				wordEndIndex++;
			}
		}
		if (wordStartIndex < wordEndIndex) {
			reverseWord(charArray, wordStartIndex, wordEndIndex);
		}

		return new String(charArray);
	}

	private static void reverseWord(char[] charArray, int startIndex, int endIndex) {
		for (int i = 0; i < (endIndex - startIndex) / 2; i++) {
			char tempChar = charArray[startIndex + i];
			charArray[startIndex + i] = charArray[endIndex - 1 - i];
			charArray[endIndex - 1 - i] = tempChar;
		}
	}

	public static String removeChars(String str, String remove) {
		if (str == null) {
			return null;
		}
		if (remove == null) {
			return str;
		}

		Set<Integer> removeSet = new HashSet<>();
		for (int i = 0; i < remove.length();) {
			int codePoint = remove.codePointAt(i);
			removeSet.add(codePoint);
			int codePointCharCount = Character.charCount(codePoint);
			i += codePointCharCount;
		}

		char[] resultCharArray = str.toCharArray();
		int index = 0;

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			int codePointCharCount = Character.charCount(codePoint);
			char[] codePointChars = Character.toChars(codePoint);
			if (!removeSet.contains(codePoint)) {
				System.arraycopy(codePointChars, 0, resultCharArray, index, codePointCharCount);
				index += codePointCharCount;
			}
			i += codePointCharCount;
		}
		return new String(resultCharArray, 0, index);
	}

	public static String firstNoneRepeated(String str) {
		if (str == null) {
			return null;
		}

		Set<Integer> onceCharSet = new HashSet<>();
		Set<Integer> duplicateCharSet = new HashSet<>();

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			int codePointCharCount = Character.charCount(codePoint);
			String charString = new String(Character.toChars(codePoint));
			System.out.print(charString + "(" + codePointCharCount + ") ");
			if (!duplicateCharSet.contains(codePoint)) {
				if (!onceCharSet.contains(codePoint)) {
					onceCharSet.add(codePoint);
				} else {
					onceCharSet.remove(codePoint);
					duplicateCharSet.add(codePoint);
				}
			}
			i += codePointCharCount;
		}
		System.out.println();

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			if (onceCharSet.contains(codePoint)) {
				return new String(Character.toChars(codePoint));
			}
			i += Character.charCount(codePoint);
		}

		return null;
	}
}
