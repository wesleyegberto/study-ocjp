package threading;

public class ThreadJoinTest {
	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable(), "T1");
		
		System.out.println("About to start the new thread T1");
		t.start();
		
		// Aguardará a thread t executar até que o tempo expire
		// ou a thread finalize (morra - 
		try {
			t.join(4000); // deverá expirar antes da saída "T1 8"
		} catch (InterruptedException e) {
		}
		
		System.out.println("Back in main()");
		

		System.out.println("\n\nAbout to start the new thread T2");
		t = new Thread(new MyRunnable(), "T2");
		t.start();
		
		try {
			t.join(); // esperará a thread terminar
		} catch (InterruptedException e) {
		}
	}
}

class MyRunnable implements Runnable {
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}