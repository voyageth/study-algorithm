package linkedlist;

/**
 * @author voyageth 2016-10-19
 */
public class SinglyLinkedListTest {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.insertInFront(0);
        System.out.println(list.checkCorrectOrder(0, null));

        list.insertInFront(1);
        System.out.println(list.checkCorrectOrder(1, 0, null));
        list.insertInFront(3);
        System.out.println(list.checkCorrectOrder(3, 1, 0, null));
        list.insertInFront(2);
        System.out.println(list.checkCorrectOrder(2, 3, 1, 0, null));

        System.out.println(list.checkCorrectOrder(list.find(3), 3, 1, 0, null));
        System.out.println(list.checkCorrectOrder(list.find(1), 1, 0, null));

        list.deleteElement(list.find(3));
        System.out.println(list.checkCorrectOrder(2, 1, 0, null));
        list.deleteElement(list.find(2));
        System.out.println(list.checkCorrectOrder(1, 0, null));

        System.out.println(list.findMToLastElement(0) != null);
        System.out.println(list.findMToLastElement(0).getData() == 0);
        System.out.println(list.findMToLastElement(1) != null);
        System.out.println(list.findMToLastElement(1).getData() == 1);
        System.out.println(list.findMToLastElement(2) == null);

        list.deleteList();
        System.out.println(list.checkCorrectOrder());
    }
}
