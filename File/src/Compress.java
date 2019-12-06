import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Compress {
	public static void main(String[] args) throws UnsupportedEncodingException, DataFormatException {
		//nen
		String input = "The Deflater class compress the data. The Deflater class compress the data. The Deflater class compress the data.The Deflater class compress the data. The Deflater class compress the data. The Deflater class compress the data.The Deflater class compress the data. The Deflater class compress the data. The Deflater class compress the data.The Deflater class compress the data. The Deflater class compress the data. The Deflater class compress the data.The Deflater class compress the data. The Deflater class compress the data. The Deflater class compress the data.";
		byte[] inputObj = input.getBytes("UTF-8");
		System.out.println("length: " + inputObj.length);
		
		//compress the bytes
		byte[] output = new byte[1024];
		Deflater deflater = new Deflater();
		deflater.setInput(inputObj);
		deflater.finish();
		int compressDataLength = deflater.deflate(output);
		System.out.println(compressDataLength);
		
		
		//giai nen
		Inflater inflaterObj = new Inflater();
		inflaterObj.setInput(output, 0, output.length);
		byte[] resultObj = new byte[1024];
		int resultLength = inflaterObj.inflate(resultObj);
		inflaterObj.end();
		
		String output1 = new String(resultObj, 0, resultLength);
		System.out.println(output1);
	}
}
