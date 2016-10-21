package linkedlist;

/**
 * @author voyageth 2016-10-21
 */
public class CyclicLinkedListTest {
    public static void main(String[] args) {
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
