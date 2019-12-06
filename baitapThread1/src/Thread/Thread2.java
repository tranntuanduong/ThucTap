package Thread;

public class Thread2 extends Thread {
	SharedData sharedData;

	public Thread2(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < sharedData.addressList.length; i++) {
			synchronized (sharedData) {
				sharedData.notifyAll(); 
				try {
					sharedData.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("address: " + sharedData.addressList[i]);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchronized (sharedData) {
			sharedData.notifyAll();
		}
		System.out.println("T2 stop");
	}
}
