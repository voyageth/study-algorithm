package tree;

import linkedlist.stack.LinkedListStack;

/**
 * @author voyageth
 *         2016-10-21
 */
public class NonRecPreorderTraversalTest {
    public static void main(String[] args) {
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
        while(current != null) {
            System.out.println(current.getValue());
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            try {
                current = stack.pop();
            }catch (IllegalStateException e) {
                // ok. null
                current = null;
            }
        }
    }
}
