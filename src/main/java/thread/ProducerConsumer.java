package thread;

import java.util.Random;

/**
 * @author voyageth
 *         2016-11-11
 */
public class ProducerConsumer {
	public void run() {
		IntBuffer buffer = new IntBuffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		producer.start();
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		consumer.start();
	}
}

class IntBuffer {
	private int index;
	private int[] buffer = new int[8];

	public synchronized void add(int num) {
		long threadId = Thread.currentThread().getId();
		while (index == buffer.length - 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("[" + threadId + "] Buffer.add. index : " + index);
		buffer[index++] = num;
		notifyAll();
	}

	public synchronized int remove() {
		long threadId = Thread.currentThread().getId();
		while (index == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int returnValue = buffer[--index];
		System.out.println("[" + threadId + "] Buffer.remove. index : " + index);
		notifyAll();
		return returnValue;
	}
}

class Producer extends Thread {
	private IntBuffer buffer;

	public Producer(IntBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			long threadId = Thread.currentThread().getId();
			Random r = new Random();
			while (true) {
				int num = r.nextInt();
				buffer.add(num);
				System.out.println("[" + threadId + "] Produced " + num);
				Thread.sleep(100L);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Consumer extends Thread {
	private IntBuffer buffer;

	public Consumer(IntBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		try {
			long threadId = Thread.currentThread().getId();
			while (true) {
				int num = buffer.remove();
				System.out.println("[" + threadId + "] Consumed " + num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}