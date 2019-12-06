package Thread;

public class CheckBalance extends Thread {
	Balance balance;
	
	
	public CheckBalance(Balance balance) {
		super();
		this.balance = balance;
	}


	@Override
	public void run() {
		while(true) {
			System.out.println("Thread3 kiem tra so du: " + balance.getBalance());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
