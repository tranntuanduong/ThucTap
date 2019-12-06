package Thread;

public class Thread1 extends Thread {
	SharedData shareData;

	public Thread1(SharedData shareData) {
		super();
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < shareData.userList.length; i++) {
			synchronized (shareData) {
				System.out.println("user name: " + shareData.userList[i]);		
				shareData.notifyAll();
				try {
					shareData.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		System.out.println("T1 stop");
	}
}
