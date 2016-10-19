package linkedlist;

/**
 * @author voyageth
 *         2016-10-19
 */
public class SinglyLinkedList<T> {
	private SinglyLinkedListItem<T> head;
	private SinglyLinkedListItem<T> tail;

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

	public boolean insertAfter(SinglyLinkedListItem<T> item, T value) {
		SinglyLinkedListItem<T> newItem = new SinglyLinkedListItem<>(value);
		if (item == null) {
			newItem.setNext(this.head);
			this.head = newItem;
			if (this.tail == null) {
				this.tail = newItem;
			}
			return true;
		}

		SinglyLinkedListItem<T> currentItem = this.head;
		while (currentItem != null) {
			if (currentItem == item) {
				newItem.setNext(currentItem.getNext());
				currentItem.setNext(newItem);
				if (currentItem == this.tail) {
					this.tail = newItem;
				}
				return true;
			}
			currentItem = currentItem.getNext();
		}

		return true;
	}

	public boolean deleteElement(SinglyLinkedListItem<T> deleteMe) {
		// head == null
		if (this.head == null || deleteMe == null) {
			return false;
		}

		if (this.head == deleteMe) {
			this.head = deleteMe.getNext();
			if (this.head == null) {
				this.tail = null;
			}
			return true;
		}

		SinglyLinkedListItem<T> currentItem = this.head;
		while (currentItem != null) {
			if (currentItem.getNext() == deleteMe) {
				currentItem.setNext(deleteMe.getNext());
				if (currentItem.getNext() == null) {
					this.tail = currentItem;
				}
				return true;
			}
			currentItem = currentItem.getNext();
		}

		return false;
	}

	public void deleteList() {
		this.head = null;
		this.tail = null;
	}

	public SinglyLinkedListItem<T> findMToLastElement(int m) {
		if (head == null) {
			return null;
		}

		SinglyLinkedListItem<T> currentItem = this.head;
		for (int i = 0; i < m; i++) {
			if (currentItem.getNext() == null) {
				return null;
			} else {
				currentItem = currentItem.getNext();
			}
		}

		SinglyLinkedListItem<T> mBehindItem = this.head;
		while (currentItem.getNext() != null) {
			currentItem = currentItem.getNext();
			mBehindItem = mBehindItem.getNext();
		}

		return mBehindItem;
	}

	public SinglyLinkedListItem<T> getHead() {
		return this.head;
	}

	public SinglyLinkedListItem<T> getTail() {
		return tail;
	}
}
