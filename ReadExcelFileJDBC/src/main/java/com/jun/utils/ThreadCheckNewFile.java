package com.jun.utils;

import java.io.File;

import org.apache.log4j.Logger;

import com.jun.shareData.ShareData;

//.. chi can 1 thread
public class ThreadCheckNewFile extends Thread {
	private static final Logger log = Logger.getLogger(ThreadCheckNewFile.class);
	private ShareData shareData;

	public ThreadCheckNewFile(ShareData shareData) {
		this.shareData = shareData;
	}

	@Override
	public void run() {
		log.info("Thread check new file -- start");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shareData != null) {
				File[] files = new File("excelFile").listFiles();
				if (files != null) {
					for (File file : files) {
						if (file.isFile()) {
							if (!shareData.getCheckList().contains(file.getName())) {
								shareData.getNewList().add(file.getName() + "");
								shareData.getCheckList().add(file.getName() + "");
							}
						}
					}
				}
			}
		}
	}
}
