package Thread;

public class SendMoney extends Thread {
	Balance balance;
	
	
	public SendMoney(Balance balance) {
		super();
		this.balance = balance;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (balance) {
				balance.change(1000);
				System.out.println("Thread1 cong tien " + 1000 + " so du:" + balance.getBalance());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance.notifyAll();
				try {
					balance.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
