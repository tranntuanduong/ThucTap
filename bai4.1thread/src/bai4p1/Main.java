package bai4p1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
	public static void main(String[] args) {
		System.out.println("Main started");
		PhoneNumber phoneNumber = new PhoneNumber();
		PhoneNumberFunction phoneNumberFunction = new PhoneNumberFunction(phoneNumber);
		ReadData readData = new ReadData(phoneNumber, phoneNumberFunction);
		readData.start();
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("data.filter.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			Thread1[] thread = new Thread1[3];
			for (int i = 0; i < 3; i++) {
				thread[i] = new Thread1(readData, phoneNumberFunction, phoneNumber);
				thread[i].setName("Thread_" + i);
				thread[i].start();
			}

			for (int i = 0; i < 3; i++) {
				if (thread[i].isAlive()) {
					System.out.println("Thread " + i + " joined");
					thread[i].join();
				}
			}
			phoneNumberFunction.writeFile(phoneNumber.getFilterPhoneNumber(), fileWriter, bufferedWriter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main end");
	}

}
