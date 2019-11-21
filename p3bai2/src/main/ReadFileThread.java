package main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReadFileThread extends Thread{
	boolean isFileUpdate;
	ReadXmlFile readXmlFile = new ReadXmlFile();
	CheckFile checkFile = new CheckFile();
	File fXmlFile = new File("config.xml");
	List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
	
	public List<Map<String, Object>> getResult() {
		return result;
	}
	public void setResult(List<Map<String, Object>> result) {
		this.result = result;
	}
	
	
	public void run() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		while(true) {
			try {
				isFileUpdate = checkFile.isFileUpdate(fXmlFile);
				Thread.sleep(1000);
				if(!isFileUpdate) {
		   			 System.out.println("oldList = newList");
		   		 } else {
		   			 list = readXmlFile.readFile("config.xml");
		   			 System.out.println("oldList # newList");
		   		 }	    
				
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
		
//		result = readXmlFile.readFile("G:/file//config.xml");		
	}
	

	
	
}
