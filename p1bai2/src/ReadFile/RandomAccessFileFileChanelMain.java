package ReadFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileFileChanelMain {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		int lines = 100;
		int readLines = 0;
		File file = new File("data.txt");
		StringBuilder builder = new StringBuilder();
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		FileChannel inChannel = randomAccessFile.getChannel();
		ByteBuffer buff = ByteBuffer.allocate(2);
		long fileLength = file.length() - 1;
		randomAccessFile.seek(fileLength);
		for (long pointer = fileLength; pointer >= 0; pointer--) {
			char c;
			randomAccessFile.seek(pointer);
			int bytesRead = inChannel.read(buff);
			buff.flip();
			c = (char) buff.get();
			if (c == '\n') {
				readLines++;
				if (readLines == lines)
					break;
			}
			builder.append(c);
			fileLength = fileLength - pointer;
			buff.clear();
			bytesRead = inChannel.read(buff);
		}
		builder.reverse();
		System.out.println(builder.toString());
		long stopTime = System.currentTimeMillis();

		long elapsedTime = stopTime - startTime;
		System.out.println("elapsedTime=" + elapsedTime);
	}

}
