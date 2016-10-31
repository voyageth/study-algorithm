package string;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-10-28
 */
public class StringUtilsTest {
	@Test
	public void reverseWordsTest() {
		System.out.println(StringUtils.reverseWords("Do or do not, there is no try."));
	}

	@Test
	public void test() {
		System.out.println(StringUtils.firstNoneRepeated("total"));
		System.out.println(StringUtils.firstNoneRepeated("teeter"));
		System.out.println(StringUtils.firstNoneRepeated("가나다가가다❤❤"));
		System.out.println(StringUtils.firstNoneRepeated("aA🇦🇨🇦🇸🇦🇴🇧🇧🇦🇴🐵a🦁a🐱🐅🐱🐕😉😄😊🙂"));
		System.out.println(StringUtils.firstNoneRepeated("暇暇蘿暇\uD841\uDF0E暇暇暇\uD841\uDF0E"));
	}

	@Test
	public void removeCharsTest() {
		System.out.println(StringUtils.removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
	}
}