package com.jun.model;

import java.util.ArrayList;
import java.util.List;

public class Provincial {

	private Long id;

	private String name;

	private List<Company> transportUnits = new ArrayList<>();

	private List<Vehicle> vehicles = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Company> getTransportUnits() {
		return transportUnits;
	}

	public void setTransportUnits(List<Company> transportUnits) {
		this.transportUnits = transportUnits;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
