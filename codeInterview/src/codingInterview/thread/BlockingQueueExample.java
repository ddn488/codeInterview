package codingInterview.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {

		BlockingQueue bq = new ArrayBlockingQueue(1000);

		Producer producer = new Producer(bq);
		Consumer consumer = new Consumer(bq);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

}

class Consumer implements Runnable {

	protected BlockingQueue queue = null;

	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
			System.out.println("Consumed: " + queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {

	private BlockingQueue bq = null;

	public Producer(BlockingQueue queue) {
		this.bq = queue;
	}

	public void run() {

		Random rand = new Random();
		int res = 0;
		try {
			res = addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);			
			Thread.sleep(1000);
			
			res = addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);
			Thread.sleep(1000);
			
			res = addition(rand.nextInt(100), rand.nextInt(50));
			System.out.println("Produced: " + res);
			bq.put(res);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int addition(int x, int y) {
		return x + y;
	}
}