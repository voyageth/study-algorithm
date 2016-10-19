package linkedlist;

/**
 * @author voyageth
 *         2016-10-19
 */
public class SinglyLinkedList<T> {
	private SinglyLinkedListItem<T> head;

	private boolean compareTwoValue(T value1, T value2) {
		if (value1 == null) {
			if (value2 == null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (value2 == null) {
				return false;
			} else {
				return value1.equals(value2);
			}
		}
	}

	public boolean checkCorrectOrder(T... expectedValueArray) {
		return checkCorrectOrder(this.head, expectedValueArray);
	}

	public boolean checkCorrectOrder(SinglyLinkedListItem<T> head, T... expectedValueArray) {
		SinglyLinkedListItem<T> element = head;

		if (expectedValueArray == null || expectedValueArray.length == 0) {
			if (element == null) {
				return true;
			} else {
				return false;
			}
		}

		for (T expectedValue : expectedValueArray) {
			if (element == null) {
				if (expectedValue == null) {
					return true;
				} else {
					return false;
				}
			}

			if (!compareTwoValue(expectedValue, element.getData())) {
				return false;
			}

			element = element.getNext();
		}

		return true;
	}

	public void insertInFront(T value) {
		SinglyLinkedListItem<T> newItem = new SinglyLinkedListItem<>(value);
		newItem.setNext(this.head);
		this.head = newItem;
	}

	public SinglyLinkedListItem<T> find(T value) {
		SinglyLinkedListItem<T> element = head;
		while (element != null) {
			if (compareTwoValue(element.getData(), value)) {
				return element;
			} else {
				element = element.getNext();
			}
		}

		// can not find
		return null;
	}

	public void deleteElement(SinglyLinkedListItem<T> deleteMe) {
		if (this.head == null || deleteMe == null) {
			return;
		}

		if (this.head == deleteMe) {
			this.head = this.head.getNext();
			return;
		}

		SinglyLinkedListItem<T> element = this.head;
		while (element != null) {
			if (element.getNext() == deleteMe) {
				element.setNext(deleteMe.getNext());
				return;
			}
			element = element.getNext();
		}
	}

	public void deleteList() {
		this.head = null;
	}

	public SinglyLinkedListItem<T> getHead() {
		return this.head;
	}
}
