package tree;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-10-26
 */
public class TreeNodeTest {
	@Test
	public void treeHeightTest() {
		TreeNode<String> h = new TreeNode<>("h", null);
		TreeNode<String> g = new TreeNode<>("g", null);
		TreeNode<String> f = new TreeNode<>("f", null);
		TreeNode<String> e = new TreeNode<>("e", h);
		TreeNode<String> d = new TreeNode<>("d", f, g);
		TreeNode<String> c = new TreeNode<>("c", d, e);
		TreeNode<String> b = new TreeNode<>("b", null);
		TreeNode<String> a = new TreeNode<>("a", b, c);

		System.out.println(TreeNode.findTreeHeight(a));
	}
}