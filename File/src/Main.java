import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			fileInputStream = new FileInputStream("text.txt");
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			byte[] data = new byte[40];
			int length = bufferedInputStream.read(data);
			System.out.println("length: " + length);
			String result = new String(data, 0, length);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			if(fileInputStream != null) {
				fileInputStream.close();
			}
			if(bufferedInputStream != null) {
				bufferedInputStream.close();
			}
		}
	}
}
