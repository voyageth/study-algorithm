package linkedlist.stack;

/**
 * @author voyageth
 *         2016-10-19
 */
public class LinkedListStackTest {
	public static void main(String[] args) {
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		stack.push(0);
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(4);

		System.out.println(4 == stack.pop());
		System.out.println(3 == stack.pop());
		System.out.println(1 == stack.pop());
		System.out.println(2 == stack.pop());
		System.out.println(0 == stack.pop());
		try {
			stack.pop();
			System.out.println("should throw Exception!");
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
