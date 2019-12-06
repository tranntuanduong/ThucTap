package com.jun.service;

import java.util.List;

import com.jun.model.Vehicle;

public interface IVehicleService {
	Vehicle save(Vehicle newVehicle);
	void saveList(List<Vehicle> vehicleList);
}
