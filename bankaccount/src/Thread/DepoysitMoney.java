package Thread;

public class DepoysitMoney extends Thread {
	Balance balance;
	
	
	public DepoysitMoney(Balance balance) {
		super();
		this.balance = balance;
	}


	@Override
	public void run() {
		while(true) {
			synchronized (balance) {
				balance.notifyAll();
				try {
					balance.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(balance.getBalance() < 1000) {
					System.out.println("khong du so du");
				} else {
					balance.change(-2000);
					System.out.println("Thread2 tru tien " + 2000 + " so du:" + balance.getBalance());
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
