package main;

import java.io.File;

public class CheckFile {
	private long timeStamp;
	private File file;
	
	public boolean isFileUpdate(File file) {
		long timeStamp = 0;
		this.file = file;
		timeStamp = file.lastModified();
		
		if(this.timeStamp != timeStamp) {
			this.timeStamp = timeStamp;
			return true;
		} else {
			return false;
		}	
	}
}

