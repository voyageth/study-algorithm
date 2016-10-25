package tree;

/**
 * @author voyageth
 *         2016-10-26
 */
public class NearestCommonAncestorTest {
	public static void main(String[] args) {
		BinaryTreeNode<Integer> n_4 = new BinaryTreeNode<>(null, null, 4);
		BinaryTreeNode<Integer> n_10 = new BinaryTreeNode<>(null, null, 10);
		BinaryTreeNode<Integer> n_14 = new BinaryTreeNode<>(null, null, 14);
		BinaryTreeNode<Integer> n_12 = new BinaryTreeNode<>(n_10, n_14, 12);
		BinaryTreeNode<Integer> n_8 = new BinaryTreeNode<>(n_4, n_12, 8);
		BinaryTreeNode<Integer> n_22 = new BinaryTreeNode<>(null, null, 22);
		BinaryTreeNode<Integer> n_20 = new BinaryTreeNode<>(n_8, n_22, 20);

		System.out.println(findNearestCommonAncestor(n_20, 4, 14).getValue());
	}

	public static BinaryTreeNode<Integer> findNearestCommonAncestor(BinaryTreeNode<Integer> root, int nodeValue1, int nodeValue2) {
		if (root == null) {
			return null;
		}

		int minNodeValue = Math.min(nodeValue1, nodeValue2);
		int maxNodeValue = Math.max(nodeValue1, nodeValue2);

		BinaryTreeNode<Integer> currentNode = root;
		while (currentNode != null) {
			if (currentNode.getValue() == null) {
				throw new IllegalStateException("node's value should not be null");
			}

			if (currentNode.getValue() < minNodeValue) {
				currentNode = currentNode.getRight();
			} else if (currentNode.getValue() > maxNodeValue) {
				currentNode = currentNode.getLeft();
			} else {
				return currentNode;
			}
		}

		return null;
	}
}
