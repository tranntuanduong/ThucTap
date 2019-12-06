package Thread;

public class Balance {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public synchronized void change(int money) {
		balance += money;
	}
}
