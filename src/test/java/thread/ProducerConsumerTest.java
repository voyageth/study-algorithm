package thread;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-11
 */
public class ProducerConsumerTest {
	@Test
	public void test() {
		ProducerConsumer producerConsumer = new ProducerConsumer();
		producerConsumer.run();
	}
}