package p3bai4;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhoneNumberFunction {
	PhoneNumber phoneNumber;
	
	public PhoneNumberFunction(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public  List<String> filterPhoneNumber(String x, List<String> list) {
		List<String> phoneList = new ArrayList<String>();
		for(String phoneNumber : list) {
			if(phoneNumber.startsWith(x, 4)) 
				phoneList.add(phoneNumber);				
		}
		return phoneList;
	}
	
	public  synchronized boolean validPhoneNumber(String phoneNumber) {
		if(phoneNumber.startsWith("+84"))
			return true;
		return false;	
	}
	
	public  synchronized String formatPhoneNumber(String phoneNumber) {
		if(phoneNumber.startsWith("+8411")) {
			if(phoneNumber.length() == 12) {
				phoneNumber = phoneNumber.substring(0,3) + "8" + phoneNumber.substring(5, 12);
			}
			if(phoneNumber.length() == 13) {
				phoneNumber = phoneNumber.substring(0,3) + "8" + phoneNumber.substring(5, 13);
			}
		}
		return phoneNumber;
	}
		
	public  void readFile() {
		FileInputStream fileInputStream = null;
		StringBuilder phoneNBuilder = new StringBuilder();
//		List<String> phoneList = new ArrayList<>();
		
		try {
			fileInputStream = new FileInputStream("cdr.txt");
			int ch;
			while((ch = fileInputStream.read()) != -1) {
				if(ch != 13) {
					if(ch != 10) 
						phoneNBuilder.append((char) ch);					
				} else {
					phoneNumber.getPhoneNumberList().add(phoneNBuilder.toString());
					phoneNBuilder.setLength(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileInputStream != null) 
					fileInputStream.close();									
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
//		return phoneList;
	}

	public void writeFile(List<String> list, FileWriter fileWriter, BufferedWriter bufferedWriter) {
		try {		
			for(String phoneNumber : list) {
				if(phoneNumber != null) {
					bufferedWriter.write(phoneNumber + (char) 13);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
