package linkedlist;

/**
 * @author voyageth 2016-10-20
 */
public class DoubleLinkedList<T> {
    private DoubleLinkedListItem<T> head;
    private DoubleLinkedListItem<T> tail;

    public void print(boolean printChild) {
        print(printChild, 0);
    }

    public void print(boolean printChild, int indent) {
        printItem(printChild, indent, this.head);
    }

    private void printItem(boolean printChild, int indent, DoubleLinkedListItem<T> currentItem) {
        while (currentItem != null) {
            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.print("me : " + currentItem);
            System.out.print(", prev : " + currentItem.getPrev());
            System.out.print(", value : " + currentItem.getValue());
            System.out.print(", next : " + currentItem.getNext());
            System.out.println(", child : " + currentItem.getChild());
            if (printChild && currentItem.getChild() != null) {
                printItem(printChild, indent + 1, currentItem.getChild());
            }
            currentItem = currentItem.getNext();
        }
    }

    public void unflattenList() {
        if (this.head == null) {
            return;
        }

        unflatten(this.head);

        DoubleLinkedListItem<T> currentItem = this.head;
        while (currentItem.getNext() != null) {
            currentItem = currentItem.getNext();
        }

        this.tail = currentItem;
    }

    private void unflatten(DoubleLinkedListItem<T> item) {
        DoubleLinkedListItem<T> currentItem = item;
        while (currentItem != null) {
            if (currentItem.getChild() != null) {
                if (currentItem.getChild().getPrev() != null) {
                    currentItem.getChild().getPrev().setNext(null);
                    currentItem.getChild().setPrev(null);
                    unflatten(currentItem.getChild());
                }
            }
            currentItem = currentItem.getNext();
        }
    }

    public void flattenList() {
        if (this.head == null) {
            return;
        }

        DoubleLinkedListItem<T> currentItem = this.head;
        while (currentItem != null) {
            if (currentItem.getChild() != null) {
                append(currentItem.getChild());
            }
            currentItem = currentItem.getNext();
        }
    }

    public void append(DoubleLinkedListItem<T> newItem) {
        if (newItem == null) {
            return;
        }

        if (this.head == null) {
            this.head = newItem;
            this.tail = newItem;
            return;
        }

        this.tail.setNext(newItem);
        newItem.setPrev(this.tail);

        while (newItem.getNext() != null) {
            newItem = newItem.getNext();
        }

        this.tail = newItem;
    }

    public DoubleLinkedListItem<T> getHead() {
        return head;
    }

    public void setHead(DoubleLinkedListItem<T> head) {
        this.head = head;
    }

    public DoubleLinkedListItem<T> getTail() {
        return tail;
    }

    public void setTail(DoubleLinkedListItem<T> tail) {
        this.tail = tail;
    }
}
