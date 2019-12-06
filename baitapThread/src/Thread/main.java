package Thread;

public class main {
	public static void main(String[] args) throws InterruptedException {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		t2.join();
		t1.join();
		
		System.out.println( "------------");
		for(int i = 0; i < t1.list1.size(); i++) {
			System.out.println("t1: " + t1.list1.get(i));
		}
		
		for(int i = 0; i < t2.list2.size(); i++) {
			System.out.println("t2: " + t2.list2.get(i));
		}
		
		
	}
}	
