package tree;

import org.junit.Test;

import linkedlist.stack.LinkedListStack;

/**
 * @author voyageth
 *         2016-10-26
 */
public class BinaryTreeNodeTest {
	@Test
	public void nearestCommonAncestorTest() {
		BinaryTreeNode<Integer> n_4 = new BinaryTreeNode<>(null, null, 4);
		BinaryTreeNode<Integer> n_10 = new BinaryTreeNode<>(null, null, 10);
		BinaryTreeNode<Integer> n_14 = new BinaryTreeNode<>(null, null, 14);
		BinaryTreeNode<Integer> n_12 = new BinaryTreeNode<>(n_10, n_14, 12);
		BinaryTreeNode<Integer> n_8 = new BinaryTreeNode<>(n_4, n_12, 8);
		BinaryTreeNode<Integer> n_22 = new BinaryTreeNode<>(null, null, 22);
		BinaryTreeNode<Integer> n_20 = new BinaryTreeNode<>(n_8, n_22, 20);

		System.out.println(BinaryTreeNode.findNearestCommonAncestor(n_20, 4, 14).getValue());
	}

	@Test
	public void nonRecursivePreorderTraversalTest() {
		BinaryTreeNode<Integer> n_25 = new BinaryTreeNode<>(null, null, 25);
		BinaryTreeNode<Integer> n_75 = new BinaryTreeNode<>(null, null, 75);
		BinaryTreeNode<Integer> n_50 = new BinaryTreeNode<>(n_25, n_75, 50);

		BinaryTreeNode<Integer> n_110 = new BinaryTreeNode<>(null, null, 110);
		BinaryTreeNode<Integer> n_125 = new BinaryTreeNode<>(n_110, null, 125);
		BinaryTreeNode<Integer> n_175 = new BinaryTreeNode<>(null, null, 175);
		BinaryTreeNode<Integer> n_150 = new BinaryTreeNode<>(n_125, n_175, 150);

		BinaryTreeNode<Integer> n_100 = new BinaryTreeNode<>(n_50, n_150, 100);

		LinkedListStack<BinaryTreeNode<Integer>> stack = new LinkedListStack<>();

		BinaryTreeNode<Integer> current = n_100;
		while (current != null) {
			System.out.println(current.getValue());
			if (current.getRight() != null) {
				stack.push(current.getRight());
			}
			if (current.getLeft() != null) {
				stack.push(current.getLeft());
			}
			try {
				current = stack.pop();
			} catch (IllegalStateException e) {
				// ok. null
				current = null;
			}
		}
	}

	@Test
	public void preorderTraversalTest() {
		BinaryTreeNode<Integer> n_25 = new BinaryTreeNode<>(null, null, 25);
		BinaryTreeNode<Integer> n_75 = new BinaryTreeNode<>(null, null, 75);
		BinaryTreeNode<Integer> n_50 = new BinaryTreeNode<>(n_25, n_75, 50);

		BinaryTreeNode<Integer> n_110 = new BinaryTreeNode<>(null, null, 110);
		BinaryTreeNode<Integer> n_125 = new BinaryTreeNode<>(n_110, null, 125);
		BinaryTreeNode<Integer> n_175 = new BinaryTreeNode<>(null, null, 175);
		BinaryTreeNode<Integer> n_150 = new BinaryTreeNode<>(n_125, n_175, 150);

		BinaryTreeNode<Integer> n_100 = new BinaryTreeNode<>(n_50, n_150, 100);

		BinaryTreeNode.printNodePreorder(n_100);
		System.out.println("----------------");
		BinaryTreeNode.printNodeInorder(n_100);
		System.out.println("----------------");
		BinaryTreeNode.printNodePostorder(n_100);
		System.out.println("----------------");
	}
}