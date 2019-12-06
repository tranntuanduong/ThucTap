package com.jun.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jun.shareData.ShareData;

@Component
public class ThreadCheckNewFile implements Runnable {
	@Autowired
	private ShareData shareData;
	
	private Thread thread;
	
	ThreadCheckNewFile() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public void run() {
		System.out.println("Thread check new file -- start");
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (shareData) {
				//..check new file
				if(shareData != null) {
					File[] files = new File("excelFile").listFiles();
					if(files != null) {
						for(File file : files) {
							if(file.isFile()) {
								shareData.getNewList().add(file.getName()+"");					
							}
						}
					}			
				}
				shareData.notifyAll();
				try {
					shareData.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
