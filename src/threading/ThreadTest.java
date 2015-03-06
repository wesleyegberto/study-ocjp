package threading;

public class ThreadTest implements Runnable {
	public void run() {
		for(int i = 0; i < 5; i++) {
			String name = Thread.currentThread().getName();
			System.out.println("In " + name + " interation " + (i + 1));
		}
	}

	public static void main(String[] args) {
		ThreadTest r = new ThreadTest();

		Thread t1 = new Thread(r, "Alfa");
		Thread t2 = new Thread(r, "Beta");

		t1.start();
		t2.start();

		System.out.println("Back in main");
	}
}
