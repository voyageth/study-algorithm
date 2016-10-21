package tree;

/**
 * @author voyageth
 *         2016-10-21
 */
public class PreorderTraversalTest {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> n_25 = new BinaryTreeNode<>(null, null, 25);
        BinaryTreeNode<Integer> n_75 = new BinaryTreeNode<>(null, null, 75);
        BinaryTreeNode<Integer> n_50 = new BinaryTreeNode<>(n_25, n_75, 50);

        BinaryTreeNode<Integer> n_110 = new BinaryTreeNode<>(null, null, 110);
        BinaryTreeNode<Integer> n_125 = new BinaryTreeNode<>(n_110, null, 125);
        BinaryTreeNode<Integer> n_175 = new BinaryTreeNode<>(null, null, 175);
        BinaryTreeNode<Integer> n_150 = new BinaryTreeNode<>(n_125, n_175, 150);

        BinaryTreeNode<Integer> n_100 = new BinaryTreeNode<>(n_50, n_150, 100);

        printNodePreorder(n_100);
        System.out.println("----------------");
        printNodeInorder(n_100);
        System.out.println("----------------");
        printNodePostorder(n_100);
        System.out.println("----------------");
    }

    private static void printNodePreorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        System.out.println(node.getValue());
        printNodePreorder(node.getLeft());
        printNodePreorder(node.getRight());
    }

    private static void printNodeInorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        printNodeInorder(node.getLeft());
        System.out.println(node.getValue());
        printNodeInorder(node.getRight());
    }

    private static void printNodePostorder(BinaryTreeNode<Integer> node) {
        if (node == null) {
            //System.out.println("null");
            return;
        }

        printNodePostorder(node.getLeft());
        printNodePostorder(node.getRight());
        System.out.println(node.getValue());
    }
}
