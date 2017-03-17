package coding;

import java.util.concurrent.*;

// The Concurrency API introduces the concept of an ExecutorServiceTest as a higher level replacement for working with threads directly.
// Executors are capable of running asynchronous tasks and typically manage a pool of threads, so we don't have to create new threads manually.
// All threads of the internal pool will be reused under the hood for revenant tasks, so we can run as many concurrent tasks 
// as we want throughout the life-cycle of our application with a single executor service.

public class ExecutorServiceTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});

		// => Hello pool-1-thread-1
		
		// In addition to Runnable executors support another kind of task named Callable. 
		// Callables are functional interfaces just like runnables but instead of being void they return a value.
		
		Callable<Integer> task = () -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		        return 123;
		    }
		    catch (InterruptedException e) {
		        throw new IllegalStateException("task interrupted", e);
		    }
		};	
		
		// the executor returns a special result of type Future which can be used to retrieve the actual result 
		// at a later point in time.
		Future<Integer> future = executor.submit(task);

		// After submitting the callable to the executor we first check if the future has already been finished execution via isDone()
		System.out.println("future done? " + future.isDone());

		Integer result;
		try {
			// Calling the method get() blocks the current thread and waits until the callable completes
			// before returning the actual result 123
			
			result = future.get();
			System.out.println("future done? " + future.isDone());
			System.out.println("result: " + result);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		Timeouts
//
//		Any call to future.get() will block and wait until the underlying callable has been terminated. 
//		In the worst case a callable runs forever - thus making your application unresponsive. 
//		You can simply counteract those scenarios by passing a timeout:
		
		// future.get(1, TimeUnit.SECONDS);		
		
		
		
		
		// notice an important difference: the java process never stops! 
		// Executors have to be stopped explicitly - otherwise they keep listening for new tasks.
		
		// An ExecutorService provides two methods for that purpose: shutdown() waits 
		// for currently running tasks to finish while shutdownNow() interrupts all running tasks and shut the executor down immediately. 
		
		try {
		    System.out.println("attempt to shutdown executor");
		    executor.shutdown();
		    executor.awaitTermination(5, TimeUnit.SECONDS);
		}
		catch (InterruptedException e) {
		    System.err.println("tasks interrupted");
		}
		finally {
		    if (!executor.isTerminated()) {
		        System.err.println("cancel non-finished tasks");
		    }
		    executor.shutdownNow();
		    System.out.println("shutdown finished");
		}
	}

}
