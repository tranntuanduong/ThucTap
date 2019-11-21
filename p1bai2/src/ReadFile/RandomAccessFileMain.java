package ReadFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileMain {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		long startTime = System.currentTimeMillis();
		int lines = 100;
		int readLines = 0;
		StringBuilder builder = new StringBuilder();
		File file = new File("data.txt");
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
			long fileLength = file.length() - 1;
			randomAccessFile.seek(fileLength);
			for (long pointer = fileLength; pointer >= 0; pointer--) {
				randomAccessFile.seek(pointer);
				char c;
				c = (char) randomAccessFile.read();
				if (c == '\n') {
					readLines++;
					if (readLines == lines)
						break;
				}
				builder.append(c);
				fileLength = fileLength - pointer;
			}
			builder.reverse();
			System.out.println(builder.toString());

		} finally {
			// close file
		}
		long stopTime = System.currentTimeMillis();

		long elapsedTime = stopTime - startTime;
		System.out.println("elapsedTime=" + elapsedTime);

	}
}
