package com.jun;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.jun.constant.Constant;
import com.jun.model.Company;
import com.jun.model.Vehicle;
import com.jun.service.ICompanyService;
import com.jun.service.IVehicleService;
import com.jun.service.impl.CompanyService;
import com.jun.service.impl.VehicleService;
import com.jun.shareData.ShareData;
import com.jun.utils.ExcelReader;
import com.jun.utils.ThreadCheckNewFile;
import com.jun.utils.ThreadWriteData;
import com.jun.utils.WriteDataToExcel;


public class ApplicationConfig {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		ShareData shareData = new ShareData();
		IVehicleService vehicleService = new VehicleService();
		ICompanyService companyService = new CompanyService();
		ExcelReader excelReader = new ExcelReader();
		WriteDataToExcel writeDataToExcel = new WriteDataToExcel();

		ThreadCheckNewFile threadCheckNewFile = new ThreadCheckNewFile(shareData);
		ThreadWriteData threadWriteData = new ThreadWriteData(shareData, vehicleService, companyService,
				excelReader);

		threadCheckNewFile.start();
		threadWriteData.start();
			
		//write excel 
		List<Vehicle> vehicleList = vehicleService.findByProvincialId(1L);
		writeDataToExcel.writeVehicle(vehicleList, "DSPTTinhBacNinh.xlsx", 1L);
			
		//..write don vi van tai
		List<Company> transportUnitList = companyService.findByCode(Constant.TRANSPORT_UNIT_CODE);
		writeDataToExcel.writerCompany(transportUnitList, "DSDVVT.xlsx", "danhsachdonvivantai", 
				Constant.TRANSPORT_UNIT_CODE, "Danh Sách Đơn Vị Vận Tải");
		
		//..write don vi truyen du lieu
		List<Company> dataTransport = companyService.findByCode(Constant.DATA_TRANSPORT_UNIT_CODE);
		writeDataToExcel.writerCompany(dataTransport, "DSDVTDL.xlsx", "danhsachdonvitruyendulieu", 
				Constant.TRANSPORT_UNIT_CODE, "Danh Sách Đơn Vị Truyền Dữ Liệu");
	}
}
