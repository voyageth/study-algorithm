package thread;

/**
 * @author voyageth
 *         2016-11-11
 */
public class BusyWating {
	public void run() {
		long threadId = Thread.currentThread().getId();
		Object theLock = new Object();
		synchronized (theLock) {
			Thread task = new TheTask(theLock);
			System.out.println("[" + threadId + "] TheTask start");
			task.start();
			try {
				System.out.println("[" + threadId + "] wait for TheTask finish start");
				theLock.wait();
				System.out.println("[" + threadId + "] wait for TheTask finish end");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class TheTask extends Thread {
	private Object theLock;

	TheTask(Object theLock) {
		this.theLock = theLock;
	}

	@Override
	public void run() {
		long threadId = Thread.currentThread().getId();
		synchronized (theLock) {
			System.out.println("[" + threadId + "] TheTask working...");
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[" + threadId + "] TheTask Finished");
			theLock.notify();
		}
	}
}
