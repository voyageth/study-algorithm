package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voyageth
 *         2016-10-28
 */
public class StringUtils {
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
