package p3bai4;

public class ReadData extends Thread {
	PhoneNumber phoneNumber;
	PhoneNumberFunction phoneNunberFunction;
	
	public ReadData(PhoneNumber phoneNumber, PhoneNumberFunction phoneNumberFunction) {
		super();
		this.phoneNumber = phoneNumber;
		this.phoneNunberFunction = phoneNumberFunction;
	}

	@Override
	public void run() {
		phoneNunberFunction.readFile();
		System.out.println("Thread readData end.");
	}
}
