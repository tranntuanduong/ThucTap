package com.jun.dao;

import java.util.List;

import com.jun.model.Vehicle;

public interface VehicleDAO extends GenericDAO<Vehicle>{
	Long save(Vehicle vehicle);
	Long update(Vehicle vehicle);
	Vehicle findByLicensePlate(String licensePlate);
	Vehicle findById(Long id);
	List<Vehicle> findAll();
	List<Vehicle> findByProvincial(Object param);
}
