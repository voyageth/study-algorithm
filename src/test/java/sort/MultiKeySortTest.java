package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-07
 */
public class MultiKeySortTest {
	@Test
	public void test() {
		MultiKeySort.Employee employee1 = new MultiKeySort.Employee("ext1", "A", "A");
		MultiKeySort.Employee employee2 = new MultiKeySort.Employee("ext1", "B", "A");
		MultiKeySort.Employee employee3 = new MultiKeySort.Employee("ext1", "C", "B");
		MultiKeySort.Employee employee4 = new MultiKeySort.Employee("ext1", "D", "C");
		MultiKeySort.Employee employee5 = new MultiKeySort.Employee("ext1", "D", null);
		MultiKeySort.Employee employee6 = new MultiKeySort.Employee("ext1", null, "B");

		List<MultiKeySort.Employee> list = new ArrayList<>();
		list.add(employee6);
		list.add(employee5);
		list.add(employee4);
		list.add(employee3);
		list.add(employee2);
		list.add(employee1);
		list.add(null);

		System.out.println(list);
		Collections.sort(list, new MultiKeySort.EmployeeAscComparator());
		System.out.println(list);
	}
}