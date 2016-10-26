package tree;

import linkedlist.stack.LinkedListStack;
import org.junit.Test;

import java.util.List;

/**
 * @author voyageth
 *         2016-10-26
 */
public class BinaryTreeNodeTest {
    @Test
    public void unbalancedBinarySearchTreeTest() {
        BinaryTreeNode<Integer> n_1 = new BinaryTreeNode<>(null, null, 1);
        BinaryTreeNode<Integer> n_3 = new BinaryTreeNode<>(null, null, 3);
        BinaryTreeNode<Integer> n_2 = new BinaryTreeNode<>(n_1, n_3, 2);
        BinaryTreeNode<Integer> n_5 = new BinaryTreeNode<>(null, null, 5);
        BinaryTreeNode<Integer> n_4 = new BinaryTreeNode<>(n_2, n_5, 4);
        BinaryTreeNode<Integer> n_7 = new BinaryTreeNode<>(null, null, 7);
        BinaryTreeNode<Integer> n_6 = new BinaryTreeNode<>(n_4, n_7, 6);

        BinaryTreeNode<Integer> root = n_6;
        System.out.println("tree height : " + getTreeHeight(root));
        System.out.println("tree.left height : " + getTreeHeight(root.getLeft()));
        System.out.println("tree.right height : " + getTreeHeight(root.getRight()));
        int heightDiff = getTreeHeight(root.getLeft()) - getTreeHeight(root.getRight());
        System.out.println("heightDiff : " + heightDiff);
        if (heightDiff > 1) {
            root = rotateRight(root);
        }
        System.out.println("tree height : " + getTreeHeight(root));
        System.out.println("tree.left height : " + getTreeHeight(root.getLeft()));
        System.out.println("tree.right height : " + getTreeHeight(root.getRight()));
        heightDiff = getTreeHeight(root.getLeft()) - getTreeHeight(root.getRight());
        System.out.println("heightDiff : " + heightDiff);
    }

    private static <T> int getTreeHeight(BinaryTreeNode<T> tree) {
        if (tree == null) {
            return 0;
        }

        return Math.max(getTreeHeight(tree.getLeft()), getTreeHeight(tree.getRight())) + 1;
    }

    private <T> BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> oldRoot) {
        BinaryTreeNode<T> newRoot = oldRoot.getLeft();
        oldRoot.setLeft(newRoot.getRight());
        newRoot.setRight(oldRoot);
        return newRoot;
    }

    @Test

    public void binaryTreeToHeapTest() {
        BinaryTreeNode<Integer> n_40 = new BinaryTreeNode<>(null, null, 40);
        BinaryTreeNode<Integer> n_10 = new BinaryTreeNode<>(null, null, 10);
        BinaryTreeNode<Integer> n_140 = new BinaryTreeNode<>(null, null, 140);
        BinaryTreeNode<Integer> n_12 = new BinaryTreeNode<>(n_10, n_140, 12);
        BinaryTreeNode<Integer> n_8 = new BinaryTreeNode<>(n_40, n_12, 8);
        BinaryTreeNode<Integer> n_22 = new BinaryTreeNode<>(null, null, 22);
        BinaryTreeNode<Integer> n_999 = new BinaryTreeNode<>(n_8, n_22, 999);

        BinaryTreeNode<Integer> root = n_999;

        BinaryTreeNode<Integer>[] array = convertTreeToArray(root);
        printArray(array);

        List<BinaryTreeNode<Integer>> list = java.util.Arrays.asList(array);
        // asc sort
        java.util.Collections.sort(list, new java.util.Comparator<BinaryTreeNode<Integer>>() {
            @Override
            public int compare(BinaryTreeNode<Integer> o1, BinaryTreeNode<Integer> o2) {
                if (o1 == null) {
                    if (o2 == null) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    if (o2 == null) {
                        return 1;
                    } else {
                        if (o1.getValue() == null) {
                            if (o2.getValue() == null) {
                                return 0;
                            } else {
                                return -1;
                            }
                        } else {
                            if (o2.getValue() == null) {
                                return 1;
                            } else {
                                return o1.getValue() - o2.getValue();
                            }
                        }
                    }
                }
            }
        });
        array = list.toArray(array);

        System.out.println("------------");
        printArray(array);

        // convert to heap
        for (int i = 1; i <= array.length; i++) {
            if (array[i - 1] == null) {
                continue;
            }

            if ((2 * i) <= array.length) {
                array[i - 1].setLeft(array[2 * i - 1]);
            } else {
                array[i - 1].setLeft(null);
            }
            if ((2 * i + 1) <= array.length) {
                array[i - 1].setRight(array[2 * i + 1 - 1]);
            } else {
                array[i - 1].setRight(null);
            }
        }

        root = array[0];
        System.out.println("------------");
        BinaryTreeNode.printNodePreorder(root);
    }

    private void printArray(BinaryTreeNode[] array) {
        for (BinaryTreeNode node : array) {
            System.out.println("node : " + node + ", value : " + node.getValue());
        }
    }

    private static <T> BinaryTreeNode<T>[] convertTreeToArray(BinaryTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }

        // find tree's size
        int treeSize = getTreeSize(tree);
        System.out.println("treeSize : " + treeSize);

        // traversal
        BinaryTreeNode[] array = new BinaryTreeNode[treeSize];
        convertTreeToArrayInner(tree, 0, array);

        return array;
    }

    private static <T> int convertTreeToArrayInner(BinaryTreeNode<T> node, int index, BinaryTreeNode[] array) {
        if (node == null) {
            return index;
        }

        array[index] = node;
        index++;

        if (node.getLeft() != null) {
            index = convertTreeToArrayInner(node.getLeft(), index, array);
        }
        if (node.getRight() != null) {
            index = convertTreeToArrayInner(node.getRight(), index, array);
        }
        return index;
    }

    private static <T> int getTreeSize(BinaryTreeNode<T> tree) {
        if (tree == null) {
            return 0;
        }

        return getTreeSize(tree.getLeft()) + getTreeSize(tree.getRight()) + 1;
    }

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