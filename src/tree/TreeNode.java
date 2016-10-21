package tree;

/**
 * @author voyageth
 *         2016-10-21
 */
public class TreeNode<T> {
    private TreeNode<T>[] children;
    private T value;

    public TreeNode(T value, TreeNode<T>... children) {
        this.value = value;
        this.children = children;
    }

    public TreeNode<T>[] getChildren() {
        return children;
    }

    public void setChildren(TreeNode<T>[] children) {
        this.children = children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
