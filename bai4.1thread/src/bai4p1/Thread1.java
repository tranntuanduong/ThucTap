package bai4p1;

public class Thread1 extends Thread {
	
	PhoneNumber phoneNumber;
	ReadData readData;
	PhoneNumberFunction phoneNumberFunction;
	public Thread1(ReadData readData, PhoneNumberFunction phoneNumberFunction, PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.readData = readData;
		this.phoneNumberFunction = phoneNumberFunction;
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName()+" started");
			while(true) {	
//				if(!phoneNumber.getPhoneNumberList().isEmpty()) {
					String phoneN;
				//	synchronized (phoneNumber) {
						 phoneN = phoneNumber.getPhoneNumberList().poll();
				//	}
					if(phoneN != null && !phoneN.isEmpty()) {
						if(phoneNumberFunction.validPhoneNumber(phoneN)) {
							String phoneFomat = phoneNumberFunction.formatPhoneNumber(phoneN);
							phoneNumber.getFilterPhoneNumber().add(phoneFomat + "-" +Thread.currentThread().getName());						
						}
					}
			//	}
				if(!readData.isAlive() && phoneNumber.getPhoneNumberList().isEmpty()) {
					break;
				}
			}					
			System.out.println(Thread.currentThread().getName()+" end");	
	}
}
