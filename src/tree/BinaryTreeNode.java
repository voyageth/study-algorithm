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
}
