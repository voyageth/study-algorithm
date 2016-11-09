package recursive;

import java.util.HashSet;
import java.util.Set;

/**
 * @author voyageth
 *         2016-11-10
 */
public class CharCombination {
	public Set<String> combination(String input) {
		Set<String> result = new HashSet<>();
		if (input == null || input.length() <= 0) {
			return result;
		}

		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length;) {
			int codePoint = Character.codePointAt(charArray, i);
			String currentChar = new String(Character.toChars(codePoint));
			Set<String> newStringSet = new HashSet<>();
			newStringSet.add(currentChar);
			for (String prev : result) {
				newStringSet.add(currentChar + prev);
			}
			result.addAll(newStringSet);
			i += Character.charCount(codePoint);
		}

		return result;
	}

}
