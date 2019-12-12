package com.jun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jun.model.BusinessType;
import com.jun.model.Company;
import com.jun.model.Provincial;
import com.jun.model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet resultSet) {
		Vehicle vehicle = new Vehicle();
		try {
			vehicle.setId(resultSet.getLong("id"));
			vehicle.setLicensePlate(resultSet.getString("license_plate"));
			vehicle.setSeat(resultSet.getInt("seat"));
			vehicle.setWeight(resultSet.getInt("weight"));
			
			Provincial provincial = new Provincial();
			provincial.setId(resultSet.getLong("provincial_id"));
			vehicle.setProvincial(provincial);
			
			Company transportUnit = new Company();
			transportUnit.setId(resultSet.getLong("transport_unit_id"));
			vehicle.setTransportUnit(transportUnit);
			
			Company dataTransport = new Company();
			dataTransport.setId(resultSet.getLong("data_transport_id"));
			vehicle.setDataTransport(dataTransport);
			
			BusinessType businessType = new BusinessType();
			businessType.setId(resultSet.getLong("business_type_id"));
			vehicle.setBusinessType(businessType);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehicle;
	}

}
