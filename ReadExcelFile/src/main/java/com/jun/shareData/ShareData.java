package com.jun.shareData;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.stereotype.Component;

@Component
public class ShareData {
	private String fileName;
	private BlockingQueue<String> newList = new LinkedBlockingDeque<>();
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
}	
