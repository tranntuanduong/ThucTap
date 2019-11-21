package p3bai4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PhoneNumber {
	private int numberThreadDied = 0;
	private BlockingQueue<String> phoneNumberList = new LinkedBlockingDeque<>();
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;
	private List<String> filterPhoneNumber = new ArrayList<>();
	
	public int getNumberThreadDied() {
		return numberThreadDied;
	}
	public void setNumberThreadDied(int numberThreadDied) {
		this.numberThreadDied = numberThreadDied;
	}
	public BlockingQueue<String> getPhoneNumberList() {
		return phoneNumberList;
	}
	public void setPhoneNumberList(BlockingQueue<String> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}
	public FileWriter getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public BufferedWriter getBufferedWriter() {
		return bufferedWriter;
	}
	public void setBufferedWriter(BufferedWriter bufferedWriter) {
		this.bufferedWriter = bufferedWriter;
	}
	public List<String> getFilterPhoneNumber() {
		return filterPhoneNumber;
	}
	public void setFilterPhoneNumber(List<String> filterPhoneNumber) {
		this.filterPhoneNumber = filterPhoneNumber;
	}

	
}
