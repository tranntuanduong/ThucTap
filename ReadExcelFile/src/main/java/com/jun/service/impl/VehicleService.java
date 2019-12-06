package com.jun.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.model.Vehicle;
import com.jun.repository.VehicleRepository;
import com.jun.service.IVehicleService;

@Service
public class VehicleService  implements IVehicleService{
	@Autowired 
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle save(Vehicle newVehicle) {
		return vehicleRepository.save(newVehicle);
	}

	@Override
	@Transactional
	public void saveList(List<Vehicle> vehicleList) {
		for(Vehicle vehicle : vehicleList) {
			vehicleRepository.save(vehicle);
		}
	}

}
