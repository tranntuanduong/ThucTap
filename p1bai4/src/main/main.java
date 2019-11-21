package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
	public static void main(String[] args) {

		List<String> phoneNumberList = new ArrayList<String>();
		phoneNumberList = readFile();
		List<String> fomatList = new ArrayList<String>();
		for(String phoneNumber : phoneNumberList) {
			if(validPhoneNumber(phoneNumber)) {
				phoneNumber = formatPhoneNumber(phoneNumber);
				fomatList.add(phoneNumber);
			}
		}
		
		List<String> filterPhoneNumber = filterPhoneNumber("1", fomatList);
		writeFile(filterPhoneNumber);
		System.out.println("success");
	}
	
	public static List<String> filterPhoneNumber(String x, List<String> list) {
		List<String> phoneList = new ArrayList<String>();
		for(String phoneNumber : list) {
			String c = phoneNumber.substring(4, 5);
			if(phoneNumber.startsWith(x, 4)) 
				phoneList.add(phoneNumber);				
		}
		return phoneList;
	}
	
	public static boolean validPhoneNumber(String phoneNumber) {
		if(phoneNumber.startsWith("+84"))
			return true;
		return false;	
	}
	
	public static String formatPhoneNumber(String phoneNumber) {
		if(phoneNumber.startsWith("+8412")) {
			if(phoneNumber.length() == 12) {
				phoneNumber = phoneNumber.substring(0,3) + "8" + phoneNumber.substring(5, 12);
			}
			if(phoneNumber.length() == 13) {
				phoneNumber = phoneNumber.substring(0,3) + "8" + phoneNumber.substring(5, 13);
			}
		}
		return phoneNumber;
	}
		
	public static List<String> readFile() {
		FileInputStream fileInputStream = null;
		StringBuilder phoneNBuilder = new StringBuilder();
		List<String> phoneList = new ArrayList<>();
		try {
			fileInputStream = new FileInputStream("cdr.txt");
			int ch;
			while((ch = fileInputStream.read()) != -1) {
				if(ch != 13) {
					if(ch != 10) 
						phoneNBuilder.append((char) ch);					
				} else {
					phoneList.add(phoneNBuilder.toString());
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
		return phoneList;
	}

	public static void writeFile(List<String> list) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter("data.filter.txt");
			bufferedWriter = new BufferedWriter(fileWriter);
			for(String phoneNumber : list) {
				bufferedWriter.write(phoneNumber + (char) 13);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bufferedWriter != null) 
					bufferedWriter.close();
				if(fileWriter != null) 
					fileWriter.close();		
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}    
	}
	
}	
