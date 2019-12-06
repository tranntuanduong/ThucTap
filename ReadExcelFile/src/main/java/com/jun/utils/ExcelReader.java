package com.jun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jun.model.BusinessType;
import com.jun.model.Provincial;
import com.jun.model.TransportUnit;
import com.jun.model.Vehicle;
import com.jun.service.IBusinessTypeService;
import com.jun.service.IProvincialService;
import com.jun.service.ITransportUnitService;

@Component
public class ExcelReader {
	@Autowired
	private ITransportUnitService transportUnitService;

	@Autowired
	private IProvincialService provincicalService;

	@Autowired
	private IBusinessTypeService businessTypeService;
	
	public List<Vehicle> readVehicleExcelFile(String fileName) {
		List<Vehicle> result = new ArrayList<>();
		String SAMPLE_XLSX_FILE_PATH = "excelFile/" + fileName;
		FileInputStream inputStream = null;
		File file = new File(SAMPLE_XLSX_FILE_PATH);
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			String a = workbook.getSheetName(0);
			Sheet sheet = workbook.getSheetAt(0);
			result = vehicle(sheet, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//..close file
			try {
				workbook.close();
				inputStream.close();
				System.out.println("close inputStream and workbook");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Vehicle> vehicle(Sheet sheet, String fileName) {
		List<Vehicle> vehicleList = new ArrayList<>();
		int columnIndex;

		// get provincical
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(3);
		String provincialName = cell.getStringCellValue().split(": ")[1];
		Provincial provincial = provincicalService.findByName(provincialName);

		for (int i = 8; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			columnIndex = 0;
			Vehicle vehicle = new Vehicle();
			vehicle.setProvincial(provincial);
			for (int j = 1; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (cell == null || cell.getStringCellValue() == "")
					continue;

				columnIndex++;
				switch (columnIndex) {
				case 1:
					// ..bien kiem soat
					vehicle.setLicensePlate(cell.getStringCellValue());
					break;
				case 2:
					// ..loai hinh
					BusinessType businessType = businessTypeService.findByName(cell.getStringCellValue());
					if (businessType == null) {
						businessType = new BusinessType();
						businessType.setName(cell.getStringCellValue());
						businessTypeService.save(businessType);
					}
					vehicle.setBusinessType(businessType);
					break;
				case 3:
					// ..don vi van tai
					TransportUnit transportUnit = transportUnitService.findByName(cell.getStringCellValue());
					if (transportUnit == null) {
						transportUnit = new TransportUnit();
						transportUnit.setName(cell.getStringCellValue());
						transportUnit.setProvincial(provincial);
						transportUnit = transportUnitService.save(transportUnit);
					}
					vehicle.setTransportUnit(transportUnit);
					break;
				case 4:
					// ..don vi truyen du lieu
					vehicle.setDataTransportUnit(cell.getStringCellValue());
					break;
				case 5:
					// ..tai trong
					String weightStr = cell.getStringCellValue();
					float weight = Float.parseFloat(weightStr.replace(",", "."));
					vehicle.setWeight(weight);
					break;
				case 6:
					// ..so ghe
					int numberSeat = Integer.parseInt(cell.getStringCellValue());
					vehicle.setSeat(numberSeat);
					break;
				}
			}
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}

	public List<TransportUnit> readTransportExcelFile(String fileName) {
		List<TransportUnit> result = new ArrayList<>();
		String SAMPLE_XLSX_FILE_PATH = "excelFile/"+fileName;
		FileInputStream inputStream = null;
		File file = new File(SAMPLE_XLSX_FILE_PATH);
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			String a = workbook.getSheetName(0);
			Sheet sheet = workbook.getSheetAt(0);
			result = transport(sheet, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//..close file
			try {
				workbook.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<TransportUnit> transport(Sheet sheet, String fileName) {
		List<TransportUnit> transportUnitList = new ArrayList<>();
		int columnIndex;
		for (int i = 8; i < sheet.getLastRowNum() + 1; i++) {
			Row row = sheet.getRow(i);
			columnIndex = 0;
			TransportUnit transportUnit = new TransportUnit();
			for (int j = 1; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null || cell.getStringCellValue() == "")
					continue;

				System.out.print(cell.getStringCellValue() + "-");
				columnIndex++;
				switch (columnIndex) {
				case 1:
					// ..save don vi van tai
					transportUnit.setName(cell.getStringCellValue());
					break;
				case 2:
					// ..ma so thue
					transportUnit.setTaxCode(cell.getStringCellValue());
					break;
				case 3:
					// ..So giao thong van tai
					Provincial provincial = provincicalService.findByName(cell.getStringCellValue());
					transportUnit.setProvincial(provincial);
					break;
				case 4:
					// ..dien thoai
					transportUnit.setPhoneNumber(cell.getStringCellValue());
					break;
				default:
					break;
				}
			}
			transportUnitList.add(transportUnit);
		}
		return transportUnitList;
	}
}
