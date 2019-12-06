package com.jun.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jun.constant.Constant;
import com.jun.model.BusinessType;
import com.jun.model.Company;
import com.jun.model.Provincial;
import com.jun.model.Vehicle;
import com.jun.service.IBusinessTypeService;
import com.jun.service.ICompanyService;
import com.jun.service.IProvincialService;
import com.jun.service.IVehicleService;
import com.jun.service.impl.BusinessTypeService;
import com.jun.service.impl.ProvincialService;
import com.jun.service.impl.CompanyService;
import com.jun.service.impl.VehicleService;

public class ExcelReader {
	private static final Logger log = Logger.getLogger(ExcelReader.class);
	private ICompanyService companyService;
	private IProvincialService provincicalService;
	private IBusinessTypeService businessTypeService;
	private IVehicleService vehicleService;
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("excelforlder");

	public ExcelReader() {
		if (companyService == null)
			companyService = new CompanyService();
		if (provincicalService == null)
			provincicalService = new ProvincialService();
		if (businessTypeService == null)
			businessTypeService = new BusinessTypeService();
		if (vehicleService == null)
			vehicleService = new VehicleService();
	}

	public List<Vehicle> readVehicleExcelFile(String fileName) {
		List<Vehicle> result = new ArrayList<>();
		String SAMPLE_XLSX_FILE_PATH = resourceBundle.getString("excelFile") + "/" + fileName;
		FileInputStream inputStream = null;
		File file = new File(SAMPLE_XLSX_FILE_PATH);
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			result = vehicle(file, sheet, fileName);
		} catch (IOException e) {
			log.info(e.getMessage());
		} finally {
			// ..close file
			try {
				workbook.close();
				inputStream.close();
				log.info("close inputStream and workbook");
			} catch (IOException e) {
				log.info(e.getMessage());
			}
		}
		return result;
	}

	public List<Vehicle> vehicle(File file, Sheet sheet, String fileName) {
		List<Vehicle> vehicleList = new ArrayList<>();
		int columnIndex;
		boolean checkFormatField = true;
		Row row;
		Cell cell;

		// ..check format filed
		row = sheet.getRow(7);
		columnIndex = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			cell = row.getCell(i);
			if (cell == null || cell.getStringCellValue() == "")
				continue;
			columnIndex++;
			if (!cell.getStringCellValue().equals(Constant.VEHICLE_FORMAT_FILE[columnIndex])) {
				checkFormatField = false;
				log.info("dinh dang file " + fileName + " khong dung");
			}
		}
		// get provincical
		row = sheet.getRow(3);
		cell = row.getCell(3);
		String provincialName = cell.getStringCellValue().split(": ")[1];
		Provincial provincial = provincicalService.findByName(provincialName);
		if (provincial != null && checkFormatField) {
			for (int i = 8; i < sheet.getLastRowNum() + 1; i++) {
				row = sheet.getRow(i);
				columnIndex = 0;
				Vehicle vehicle = null;		
				// ..load cell
				for (int j = 1; j < row.getLastCellNum(); j++) {
					cell = row.getCell(j);
					if (cell == null || cell.getStringCellValue() == "")
						continue;

					columnIndex++;
					switch (columnIndex) {
					case 1:
						// ..bien kiem soat
						vehicle = vehicleService.findByLicensePlate(cell.getStringCellValue());
						if(vehicle == null) {
							vehicle = new Vehicle();
						}
						vehicle.setProvincial(provincial);
						vehicle.setLicensePlate(cell.getStringCellValue());
						break;
					case 2:
						// ..loai hinh
						BusinessType businessType = businessTypeService.findByName(cell.getStringCellValue());
						if (businessType == null) {
							businessType = new BusinessType();
							businessType.setName(cell.getStringCellValue());
							businessType.setId(businessTypeService.save(businessType));
						}
						vehicle.setBusinessType(businessType);
						break;
					case 3:
						// ..don vi van tai
						Company transportUnit = companyService.findByName(cell.getStringCellValue());
						if (transportUnit == null) {
							transportUnit = new Company();
							transportUnit.setName(cell.getStringCellValue());
							transportUnit.setProvincial(provincial);
							transportUnit.setCode(Constant.TRANSPORT_UNIT_CODE);
							transportUnit = companyService.save(transportUnit);
						} else {
							// ..update company_code
							String transportUnitCode = transportUnit.getCode();
							if (StringUtils.isNotBlank(transportUnitCode)) {
								if (!transportUnitCode.contains(Constant.TRANSPORT_UNIT_CODE)) {
									transportUnitCode = transportUnitCode + "," + Constant.TRANSPORT_UNIT_CODE;
								}
							}
							transportUnit.setCode(transportUnitCode);
							companyService.update(transportUnit);
						}
						vehicle.setTransportUnit(transportUnit);
						break;
					case 4:
						// ..don vi truyen du lieu
						Company dataTransport = companyService.findByName(cell.getStringCellValue());
						if (dataTransport == null) {
							dataTransport = new Company();
							dataTransport.setName(cell.getStringCellValue());
							dataTransport.setProvincial(provincial);
							dataTransport.setCode(Constant.DATA_TRANSPORT_UNIT_CODE);
							dataTransport = companyService.save(dataTransport);
						} else {
							// ..update company_code
							String dataTransportCode = dataTransport.getCode();
							if (StringUtils.isNotBlank(dataTransportCode)) {
								if (!dataTransportCode.contains(Constant.DATA_TRANSPORT_UNIT_CODE)) {
									dataTransportCode = dataTransportCode + "," + Constant.DATA_TRANSPORT_UNIT_CODE;
								}
							}
							dataTransport.setCode(dataTransportCode);
							companyService.update(dataTransport);
						}
						vehicle.setDataTransport(dataTransport);
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
		} else {
			removeFileError(fileName, file);
		}

		return vehicleList;
	}

	public List<Company> readTransportExcelFile(String fileName) {
		List<Company> result = new ArrayList<>();
		String SAMPLE_XLSX_FILE_PATH = resourceBundle.getString("excelFile") + "/" + fileName;
		FileInputStream inputStream = null;
		File file = new File(SAMPLE_XLSX_FILE_PATH);
		Workbook workbook = null;
		try {
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			result = transport(sheet, fileName);
		} catch (IOException e) {
			removeFileError(fileName, file);
		} finally {
			// ..close file
			try {
				workbook.close();
				inputStream.close();
				log.info("close inputStream and workbook");
			} catch (IOException e) {
				log.info(e.getMessage());
			}
		}
		return result;
	}

	public List<Company> transport(Sheet sheet, String fileName) {
		List<Company> transportUnitList = new ArrayList<>();
		int columnIndex;
		for (int i = 8; i < sheet.getLastRowNum() + 1; i++) {
			Row row = sheet.getRow(i);
			columnIndex = 0;
			Company transportUnit = new Company();
			transportUnit.setCode(Constant.TRANSPORT_UNIT_CODE);
			for (int j = 1; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null || cell.getStringCellValue() == "")
					continue;

				columnIndex++;
				switch (columnIndex) {
				case 1:
					// ..save don vi van tai
					transportUnit.setName(cell.getStringCellValue());
					break;
				case 2:
					// ..ma so thue
					transportUnit.setTaxCode(cell.getStringCellValue().replace("-", ""));
					break;
				case 3:
					// ..So giao thong van tai
					Provincial provincial = provincicalService.findByName(cell.getStringCellValue());
					transportUnit.setProvincial(provincial);
					break;
				case 4:
					// ..dien thoai
					transportUnit.setPhoneNumber(cell.getStringCellValue().replace(".", ""));
					break;
				default:
					break;
				}
			}
			transportUnitList.add(transportUnit);
		}
		return transportUnitList;
	}

	public static void removeFileError(String fileName, File file) {

		log.info("xay ra loi khi doc file: " + fileName);
		if (file.exists()) {
			File destination = new File(resourceBundle.getString("driverName") + "/" + fileName);
			file.renameTo(destination);
			System.out.println("reNameTo: " + fileName);
			file.delete();
		}
	}
}
