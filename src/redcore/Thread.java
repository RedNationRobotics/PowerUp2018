package redcore;

public class Thread {
	
public static void main(String[] args) throws InterruptedException {
	System.out.println("Main thread starting");
	
	Course calc = new Course();
	for(int i=0; i < 10; i++) {
		System.out.println("Main thread: " + calc._Course);
		Thread.sleep(1000);
	}
	calc.Stop();
	
	System.out.println("Main thread exiting.");
	}
}
