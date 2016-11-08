package recursive;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-08
 */
public class PermutationTest {
	@Test
	public void test() {
		Permutation permutation = new Permutation();
		permutation.permute("hat");
		permutation.permute("aaa");
	}
}