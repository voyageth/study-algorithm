package tree;

/**
 * @author voyageth
 *         2016-10-21
 */
public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T value;

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void printNodePreorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        System.out.println(node.getValue());
        printNodePreorder(node.getLeft());
        printNodePreorder(node.getRight());
    }

    public static void printNodeInorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        printNodeInorder(node.getLeft());
        System.out.println(node.getValue());
        printNodeInorder(node.getRight());
    }

    public static void printNodePostorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        printNodePostorder(node.getLeft());
        printNodePostorder(node.getRight());
        System.out.println(node.getValue());
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
