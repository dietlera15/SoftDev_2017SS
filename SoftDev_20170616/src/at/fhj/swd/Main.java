package at.fhj.swd;

public class Main {

	private static int counter = 0;
	private static Object syncLock = new Object();
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				inc();
				inc();
				sinc();
				sinc();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				inc();
				inc();
				sinc();
				sinc();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println("");
		} catch (InterruptedException e) {
			
		}
	}

	public static void inc() {
		synchronized (syncLock) {
			int temp = counter + 1;
			counter = temp;
			System.out.printf("%2d ", temp);
		}
	}
	
	public synchronized static void sinc() {
		int temp = counter + 1;
		counter = temp;
		System.out.printf("%2d ", temp);
	}
}
