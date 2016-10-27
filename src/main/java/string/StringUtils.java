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

		Set<String> onceCharSet = new HashSet<>();
		Set<String> duplicateCharSet = new HashSet<>();

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			int codePointCharCount = Character.charCount(codePoint);
			String charString = new String(Character.toChars(codePoint));
			System.out.print(charString + "(" + codePointCharCount + ") ");
			if (!duplicateCharSet.contains(charString)) {
				if (!onceCharSet.contains(charString)) {
					onceCharSet.add(charString);
				} else {
					onceCharSet.remove(charString);
					duplicateCharSet.add(charString);
				}
			}
			i += codePointCharCount;
		}
		System.out.println();

		for (int i = 0; i < str.length();) {
			int codePoint = str.codePointAt(i);
			String charString = new String(Character.toChars(codePoint));
			if (onceCharSet.contains(charString)) {
				return charString;
			}
			i += Character.charCount(codePoint);
		}

		return null;
	}
}
