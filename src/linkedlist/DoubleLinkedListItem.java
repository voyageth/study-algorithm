package linkedlist;

/**
 * @author voyageth 2016-10-20
 */
public class DoubleLinkedListItem<T> {
    private DoubleLinkedListItem<T> next;
    private DoubleLinkedListItem<T> prev;
    private DoubleLinkedListItem<T> child;
    private int value;

    public DoubleLinkedListItem(int value) {
        this.value = value;
    }

    public DoubleLinkedListItem<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListItem<T> next) {
        this.next = next;
    }

    public DoubleLinkedListItem<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListItem<T> prev) {
        this.prev = prev;
    }

    public DoubleLinkedListItem<T> getChild() {
        return child;
    }

    public void setChild(DoubleLinkedListItem<T> child) {
        this.child = child;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
