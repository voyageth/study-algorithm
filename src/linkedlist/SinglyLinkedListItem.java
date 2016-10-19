package linkedlist;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
