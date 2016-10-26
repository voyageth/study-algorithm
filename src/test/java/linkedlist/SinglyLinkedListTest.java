package linkedlist;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-10-26
 */
public class SinglyLinkedListTest {
    @Test
    public void test() {
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

    @Test
    public void cyclicLinkedListTest() {
        SinglyLinkedList<Integer> cyclicList = new SinglyLinkedList<>();
        SinglyLinkedListItem<Integer> cyclicListItem1 = new SinglyLinkedListItem<>(3);
        SinglyLinkedListItem<Integer> cyclicListItem2 = new SinglyLinkedListItem<>(2);
        SinglyLinkedListItem<Integer> cyclicListItem3 = new SinglyLinkedListItem<>(4);
        SinglyLinkedListItem<Integer> cyclicListItem4 = new SinglyLinkedListItem<>(6);
        SinglyLinkedListItem<Integer> cyclicListItem5 = new SinglyLinkedListItem<>(2);
        cyclicListItem1.setNext(cyclicListItem2);
        cyclicListItem2.setNext(cyclicListItem3);
        cyclicListItem3.setNext(cyclicListItem4);
        cyclicListItem4.setNext(cyclicListItem5);
        cyclicList.setHead(cyclicListItem1);
        cyclicListItem5.setNext(cyclicListItem3);

        SinglyLinkedList<Integer> acyclicList = new SinglyLinkedList<>();
        acyclicList.insertAfter(acyclicList.getTail(), 3);
        acyclicList.insertAfter(acyclicList.getTail(), 2);
        acyclicList.insertAfter(acyclicList.getTail(), 4);
        acyclicList.insertAfter(acyclicList.getTail(), 6);
        acyclicList.insertAfter(acyclicList.getTail(), 2);

        System.out.println("cyclicList.isCyclic() : " + cyclicList.isCyclic());
        System.out.println("acyclicList.isCyclic() : " + acyclicList.isCyclic());
    }
}