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

    public static int findTreeHeight(TreeNode<String> tree) {
        if (tree == null) {
            return 0;
        }

        if (tree.getChildren() == null) {
            return 1;
        }

        int maxChildHeight = 0;
        for (TreeNode<String> child : tree.getChildren()) {
            int currentChildHeight = findTreeHeight(child);
            if (currentChildHeight > maxChildHeight) {
                maxChildHeight = currentChildHeight;
            }
        }

        return maxChildHeight + 1;
    }
}
