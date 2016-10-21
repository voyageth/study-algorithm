package linkedlist.stack;

import linkedlist.SinglyLinkedList;
import linkedlist.SinglyLinkedListItem;

/**
 * @author voyageth 2016-10-19
 */
public class LinkedListStack<T> {
    SinglyLinkedList<T> linkedList = new SinglyLinkedList<>();

    public void push(T value) {
        synchronized (this) {
            linkedList.insertInFront(value);
        }
    }

    public T pop() {
        synchronized (this) {
            SinglyLinkedListItem<T> head = linkedList.getHead();
            if (head == null) {
                throw new IllegalStateException("EMPTY");
            }
            linkedList.deleteElement(head);
            return head.getData();
        }
    }
}
