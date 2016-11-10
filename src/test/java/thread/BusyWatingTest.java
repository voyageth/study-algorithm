package thread;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-11
 */
public class BusyWatingTest {
	@Test
	public void test() {
		BusyWating busyWating = new BusyWating();
		busyWating.run();
	}

}