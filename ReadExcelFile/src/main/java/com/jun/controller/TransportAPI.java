package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jun.model.TransportUnit;
import com.jun.model.Vehicle;
import com.jun.service.ITransportUnitService;
import com.jun.service.IVehicleService;
import com.jun.utils.ExcelReader;

@RestController
public class TransportAPI {
	@Autowired
	private IVehicleService vehicleService;
	
	@Autowired
	private ITransportUnitService transportUnitService;
	
	@Autowired
	private ExcelReader excelReader;
	
	@PostMapping(value = {"/api/transport"})
	public void saveTransportUnit(@RequestParam String fileName) {
		List<TransportUnit> transportUnitList = excelReader.readTransportExcelFile(fileName);
		transportUnitService.saveList(transportUnitList);
	} 
	
	@PostMapping(value = {"/api/vehicle"})
	public void saveVehicle(@RequestParam String fileName) {
		List<Vehicle> vehicleList = excelReader.readVehicleExcelFile(fileName);
		vehicleService.saveList(vehicleList);
	} 

	
	

}
