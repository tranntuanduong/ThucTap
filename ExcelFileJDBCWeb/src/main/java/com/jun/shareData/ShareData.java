package com.jun.shareData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//..khong can -> lam phuc tap
public class ShareData {
	private String fileName;
	private BlockingQueue<String> newList = new LinkedBlockingDeque<>();
	private BlockingQueue<String> checkList = new LinkedBlockingDeque<>();
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public BlockingQueue<String> getNewList() {
		return newList;
	}
	public void setNewList(BlockingQueue<String> newList) {
		this.newList = newList;
	}
	public BlockingQueue<String> getCheckList() {
		return checkList;
	}
	public void setCheckList(BlockingQueue<String> checkList) {
		this.checkList = checkList;
	}

}	
