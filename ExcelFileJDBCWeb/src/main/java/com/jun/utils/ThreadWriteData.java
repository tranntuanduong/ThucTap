package com.jun.utils;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import com.jun.model.Company;
import com.jun.model.Vehicle;
import com.jun.service.ICompanyService;
import com.jun.service.IVehicleService;
import com.jun.shareData.ShareData;

//..chi can 1 thread
public class ThreadWriteData extends Thread {
	private static final Logger log = Logger.getLogger(ThreadWriteData.class);
	private ShareData shareData;
	private IVehicleService vehicleService;
	private ICompanyService transportUnitService;
	private ExcelReader excelReader;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("excelforlder");

	public ThreadWriteData(ShareData shareData, IVehicleService vehicleService, ICompanyService transportUnitService,
			ExcelReader excelReader) {
		this.shareData = shareData;
		this.vehicleService = vehicleService;
		this.transportUnitService = transportUnitService;
		this.excelReader = excelReader;
	}

	@Override
	public void run() {

		log.info("thread write data -- start ");
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shareData.getNewList() != null) {
				String fileName = shareData.getNewList().poll();
				File file = new File(resourceBundle.getString("excelFile") + "/" + fileName);
				if (fileName != null) {
					if (fileName.contains("DSPT")) {
						// ..doc file danh sach phuong tien
						List<Vehicle> vehicleList = excelReader.readVehicleExcelFile(fileName);
						vehicleService.saveList(vehicleList);
					} else if (fileName.contains("DSDVVT")) {
						// ..doc file danh sach don vi van tai
						List<Company> transportUnitList = excelReader.readTransportExcelFile(fileName);
						transportUnitService.saveList(transportUnitList);
					} else {
						log.info("Error: file dat ten khong dung chuan: " + fileName);
					}
					if (file.exists()) {
						File destination = new File(resourceBundle.getString("excelReaded") + "/" + fileName);
						file.renameTo(destination);
						System.out.println("reNameTo: " + fileName);
						file.delete();
						shareData.getCheckList().poll();
					}
				}
			}
		}
	}

}
