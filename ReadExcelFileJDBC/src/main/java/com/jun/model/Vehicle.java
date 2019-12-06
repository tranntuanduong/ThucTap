package com.jun.model;

public class Vehicle {
	private Long id;
	
	private String licensePlate;

	private BusinessType businessType;

	private Company transportUnit;

	private Company dataTransport;

	private Provincial provincial;
	
	private float weight;

	private int seat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public Company getTransportUnit() {
		return transportUnit;
	}

	public void setTransportUnit(Company transportUnit) {
		this.transportUnit = transportUnit;
	}

	public Company getDataTransport() {
		return dataTransport;
	}

	public void setDataTransport(Company dataTransport) {
		this.dataTransport = dataTransport;
	}

	public Provincial getProvincial() {
		return provincial;
	}

	public void setProvincial(Provincial provincial) {
		this.provincial = provincial;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
}
