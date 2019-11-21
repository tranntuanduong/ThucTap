package ReadFile;

import java.io.BufferedReader;
import java.io.FileReader;

public class BuffredReaderMain {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int lineNumber = 0;
		FileReader fin = null;;
		BufferedReader buff = null;
		try {
			fin = new FileReader("data.txt");
			buff = new BufferedReader(fin);
			String line = "";
			while((line = buff.readLine()) != null) {
				lineNumber++;
				if(lineNumber > 999900) {
					System.out.println(line);
				}
			}		
		} catch (Exception  e) {
			e.printStackTrace();
		} finally {
			try {
				if(fin != null) {
					fin.close();
				}
				if(buff != null) {
					buff.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long stopTime = System.currentTimeMillis();
		
		long elapsedTime = stopTime - startTime;
		System.out.println("elapsedTime=" + elapsedTime);
	}
}
