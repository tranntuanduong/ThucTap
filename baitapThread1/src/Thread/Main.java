package Thread;

public class Main {
	public static void main(String[] args) {
		SharedData sharedData = new SharedData();
		Thread1 t1 = new Thread1(sharedData);
		Thread2 t2 = new Thread2(sharedData);
		
		t2.start();
		t1.start();
	}
}
