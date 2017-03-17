package coding;

class Print {
	public void printCount() {
	      try {
	         for(int i = 5; i > 0; i--) {
	            System.out.println("Counter   ---   "  + i );
	         }
	      }catch (Exception e) {
	         System.out.println("Thread  interrupted.");
	      }
	   }
}

class RunThread {
	Runnable r ;
	RunThread(String name, Print print) {
		 r = () -> {
			synchronized(print) {
				print.printCount();
		      }
		      System.out.println("Thread " + name + " exiting.");
		};
	}
	Runnable getRunable() {
		return r;
	}
}

public class SyncThread {

	public static void main(String[] args) {
		Print print = new Print();
		RunThread r1 = new RunThread("1", print);
		RunThread r2 = new RunThread("2", print);
		
		Thread thread1 = new Thread(r1.getRunable());
		thread1.start();
		Thread thread2 = new Thread(r2.getRunable());
		thread2.start();
		
	}

}
