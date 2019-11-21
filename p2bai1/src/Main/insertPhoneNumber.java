package Main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import Dao.InsertPhoneNumber;
//insert batch java
public class insertPhoneNumber {
	private static InsertPhoneNumber insert = new InsertPhoneNumber();
	public static void main(String[] args) {
		insert1000Line();
		//1 line/lan elapsedTime=49571
		//100 line/lan elapsedTime 2099
		//1000 line/lan elapsedTime 27221
		//10000 line/ lan 29136
	}
	
	public static void insert1000Line() {
		try {
			
			String fileName = "data.txt";
			FileInputStream fileInputStream = new FileInputStream(fileName); 	
			//specify UTF-8 encoding explicitly
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			
			try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
				long startTime = System.currentTimeMillis();
				String line;
				int lineNumber = 0;
				StringBuilder value = new StringBuilder();
				StringBuilder sql = new StringBuilder();
				while((line = bufferedReader.readLine()) != null) {
					lineNumber++;		
					if(value.length() > 0) {
						value.append(",");
					}
					value.append("('"+line+"')");
					
					if(lineNumber == 100) {
						sql.append("insert into phonenumber(phonenumber) value");
						sql.append(value.toString());
						System.out.println(sql.toString());
						insert.insert100Line(sql.toString());
						lineNumber = 0;
						
						//reset String builder
						sql.setLength(0);
						value.setLength(0);
					}				
				}
				System.out.println("success");
				long stopTime = System.currentTimeMillis();
				
				long elapsedTime = stopTime - startTime;
				System.out.println("elapsedTime=" + elapsedTime);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//close file
		}
	}
}
