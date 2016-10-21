package linkedlist;

public class SinglyLinkedListItem<T> {
    T data;
    SinglyLinkedListItem<T> next;

    public SinglyLinkedListItem(T value) {
        setData(value);
        setNext(null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T value) {
        this.data = value;
    }

    public SinglyLinkedListItem<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListItem<T> newNext) {
        this.next = newNext;
    }
}
