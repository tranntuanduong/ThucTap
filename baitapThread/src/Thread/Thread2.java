package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread2 extends Thread {
	List<Character> list2 = new ArrayList<>();

	
	@Override
	public void run() {
		Random random = new Random();
		int min = (int) 'a';
		int max = (int) 'z';
		int deltal = max - min;
		
		for (int i = 0; i < 10; i++) {
			int rad = random.nextInt(deltal) + min;
			list2.add((char) rad);
			System.out.println("T2 > " + (char) rad);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
