package com.jun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.model.BusinessType;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Long>{
	BusinessType findByName(String name);
}
