package com.jun.utils;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jun.model.TransportUnit;
import com.jun.model.Vehicle;
import com.jun.service.ITransportUnitService;
import com.jun.service.IVehicleService;
import com.jun.shareData.ShareData;

@Component
public class ThreadWriteData implements Runnable {

	@Autowired
	private ShareData shareData;

	@Autowired
	private IVehicleService vehicleService;

	@Autowired
	private ITransportUnitService transportUnitService;

	@Autowired
	private ExcelReader excelReader;

	private Thread thread;

	ThreadWriteData() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	@Override
	public void run() {

		System.out.println("thread write data -- start ");
		while (true) {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (shareData) {
				shareData.notifyAll();
				try {
					shareData.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (shareData.getNewList() != null) {
					String fileName = shareData.getNewList().poll();
					File file = new File("excelFile/" + fileName);
					if (fileName != null) {
						if (fileName.contains("DSPT")) {
							// ..doc file danh sach phuong tien
							if (file.exists()) {
								List<Vehicle> vehicleList = excelReader.readVehicleExcelFile(fileName);
								vehicleService.saveList(vehicleList);
							}
						} else if (fileName.contains("DSDVVT")) {
							// ..doc file danh sach don vi van tai
							if (file.exists()) {
								List<TransportUnit> transportUnitList = excelReader.readTransportExcelFile(fileName);
								transportUnitService.saveList(transportUnitList);
							}
						}
						if (file.exists()) {
							File destination = new File("excelReaded/" + fileName);
							file.renameTo(destination);
							System.out.println("reNameTo: " + fileName);
						}
					}
				}
			}
		}
	}
}
