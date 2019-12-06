package com.jun.dao;

import com.jun.model.BusinessType;

public interface BusinessTypeDAO extends GenericDAO<BusinessType>{
	BusinessType findByName(String name);
	Long save(BusinessType businessType);
	BusinessType findById(Long id);
}
