package com.jun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.model.TransportUnit;

public interface TransportUnitRepository  extends JpaRepository<TransportUnit, Long>{
	TransportUnit findByTaxCode(String taxCode);
	TransportUnit findByName(String name);
}
