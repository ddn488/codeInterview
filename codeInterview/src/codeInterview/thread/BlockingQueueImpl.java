package codeInterview.thread;

import java.util.LinkedList;
import java.util.List;

//	BlockingQueueImpl is a queue which is thread safe to insert or retrieve elements from it
//	
// A blocking queue is a queue that blocks when you try to dequeue from it and the queue is empty, or 
//	if you try to enqueue items to it and the queue is already full. 
//  A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. 
//	A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue,
//	either by dequeuing one or more items or clearing the queue completely.
//
//	 A BlockingQueueImpl with one thread putting into it, and another thread taking from it.
//
//	Notice how notifyAll() is only called from enqueue() and dequeue() 
//	if the queue size is equal to the size bounds (0 or limit)

public class BlockingQueueImpl {
	private List<Object> queue = new LinkedList<Object>();
	private int limit = 10;
	
	public BlockingQueueImpl(int limit) {
		this.limit = limit;
	}
	
	public synchronized void enqueue(Object item ) throws InterruptedException {
		
		// if the queue is full then call wait() until another thread release and the queue isless than the limite
		while (this.queue.size() == this.limit) {
			wait();
		}
		
		if(this.queue.size() ==  0) {
			notifyAll();
		}
		
		this.queue.add(item);
		
	}
	
	public synchronized void dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		
		if(this.queue.size() == this.limit) {
			notifyAll();
		}
		
		this.queue.remove(0);
	}
}
