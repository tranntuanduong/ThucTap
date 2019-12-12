package com.jun.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.jun.model.Vehicle;
import com.jun.service.ICompanyService;
import com.jun.service.IProvincialService;
import com.jun.service.IVehicleService;
import com.jun.service.impl.CompanyService;
import com.jun.service.impl.ProvincialService;
import com.jun.service.impl.VehicleService;
import com.jun.shareData.ShareData;
import com.jun.utils.WriteDataToExcel;

@Path("/vehicle/api")
public class VehicleAPI {
	ShareData shareData = new ShareData();
	IVehicleService vehicleService = new VehicleService();
	ICompanyService companyService = new CompanyService();
	IProvincialService provincialService = new ProvincialService();
	WriteDataToExcel writeDataToExcel = new WriteDataToExcel();

	@GET
	@Path("{fileName}/{provincialName}")
	@Produces("application/json; charset=UTF-8")
	public String saveVehicleExcelFile(
			@PathParam("fileName") String fileName,
			@PathParam("provincialName") String provincialName) throws FileNotFoundException, IOException {
		Long provincialId = provincialService.findIdByName(provincialName);
		
		List<Vehicle> vehicleList = vehicleService.findByProvincialId(provincialId);
		writeDataToExcel.writeVehicle(vehicleList, fileName + ".xlsx", provincialId);
		return fileName + " - " + provincialName;
	}
}
