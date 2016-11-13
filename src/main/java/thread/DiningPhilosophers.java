package thread;

/**
 * @author voyageth
 *         2016-11-14
 */
public class DiningPhilosophers {
	private Object[] forks;
	private Philosopher[] philosophers;

	private DiningPhilosophers(int num) {
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for (int i = 0; i < num; i++) {
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i + 1) % num;
			if ((i % 2) == 0) {
				philosophers[i] = new Philosopher(i, fork2, fork1);
			} else {
				philosophers[i] = new Philosopher(i, fork1, fork2);
			}
		}
	}

	public static void main(String[] args) {
		try {
			DiningPhilosophers d = new DiningPhilosophers(3);
			d.startEating();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void startEating() throws InterruptedException {
		for (int i = 0; i < philosophers.length; i++) {
			philosophers[i].start();
		}

		philosophers[0].join();
	}

	private class Philosopher extends Thread {
		private int id;
		private int fork1;
		private int fork2;

		Philosopher(int id, int fork1, int fork2) {
			this.id = id;
			this.fork1 = fork1;
			this.fork2 = fork2;
		}

		public void run() {
			status("Ready to eat using forks " + fork1 + " and " + fork2);
			while (true) {
				status("Picking up for " + fork1 + "(left fork)");
				synchronized (forks[fork1]) {
					status("Picking up for " + fork2 + "(right fork)");
					synchronized (forks[fork2]) {
						status("Eating");
					}
				}
			}
		}

		private void status(String msg) {
			System.out.println("Philosopher " + id + ": " + msg);
		}
	}
}
