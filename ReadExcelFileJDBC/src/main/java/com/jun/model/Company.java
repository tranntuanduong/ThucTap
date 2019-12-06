package com.jun.model;

import java.util.ArrayList;
import java.util.List;


public class Company {

	private Long id;
	
	private String name;

	private String taxCode;
	
	private Provincial provincial;
	
	private String code;
	
	private List<Vehicle> vehicleList = new ArrayList<>();
	
	private String phoneNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Provincial getProvincial() {
		return provincial;
	}
	public void setProvincial(Provincial provincial) {
		this.provincial = provincial;
	}
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
