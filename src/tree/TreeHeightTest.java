package tree;

/**
 * @author voyageth
 *         2016-10-21
 */
public class TreeHeightTest {
    public static void main(String[] args) {
        TreeNode<String> h = new TreeNode<>("h", null);
        TreeNode<String> g = new TreeNode<>("g", null);
        TreeNode<String> f = new TreeNode<>("f", null);
        TreeNode<String> e = new TreeNode<>("e", h);
        TreeNode<String> d = new TreeNode<>("d", f, g);
        TreeNode<String> c = new TreeNode<>("c", d, e);
        TreeNode<String> b = new TreeNode<>("b", null);
        TreeNode<String> a = new TreeNode<>("a", b, c);

        System.out.println(findTreeHeight(a));
    }

    private static int findTreeHeight(TreeNode<String> tree) {
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
