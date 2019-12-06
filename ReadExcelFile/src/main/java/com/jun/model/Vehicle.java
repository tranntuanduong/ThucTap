package com.jun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "license_Plate")
	private String licensePlate;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "business_type_id")
	private BusinessType businessType;
	
	@ManyToOne
	@JoinColumn(name = "transport_unit_id")
	private TransportUnit transportUnit;
	
	@ManyToOne
	@JoinColumn(name = "provincial_id")
	private Provincial provincial;
	
	@Column (name = "data_transport_unit")
	private String dataTransportUnit;
	
	@Column (name = "weight")
	private float weight;
	
	@Column (name = "seat")
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

	public TransportUnit getTransportUnit() {
		return transportUnit;
	}

	public void setTransportUnit(TransportUnit transportUnit) {
		this.transportUnit = transportUnit;
	}

	public Provincial getProvincial() {
		return provincial;
	}

	public void setProvincial(Provincial provincial) {
		this.provincial = provincial;
	}

	public String getDataTransportUnit() {
		return dataTransportUnit;
	}

	public void setDataTransportUnit(String dataTransportUnit) {
		this.dataTransportUnit = dataTransportUnit;
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
