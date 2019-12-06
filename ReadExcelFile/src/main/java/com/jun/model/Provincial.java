package com.jun.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="provincial")
public class Provincial {
	@Id
	private Long id;
	
	@Column (name="name")
	private String name;
	
	@OneToMany(mappedBy = "provincial", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<TransportUnit> transportUnits = new ArrayList<>();
	
	@OneToMany(mappedBy = "provincial", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
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
	public List<TransportUnit> getTransportUnits() {
		return transportUnits;
	}
	public void setTransportUnits(List<TransportUnit> transportUnits) {
		this.transportUnits = transportUnits;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
