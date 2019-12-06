package Thread;

public class Main {
	public static void main(String[] args) {
		Balance balance = new Balance();
		balance.setBalance(3000);
		CheckBalance checkBalance = new CheckBalance(balance);
		DepoysitMoney depoysitMoney = new DepoysitMoney(balance);
		SendMoney sendMoney = new SendMoney(balance);
		SendMoney sendMoney1 = new SendMoney(balance);
		System.out.println("---");
		checkBalance.start();
		depoysitMoney.start();
		sendMoney.start();
		sendMoney1.start();
	}
}
