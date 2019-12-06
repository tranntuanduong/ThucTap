package com.jun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.model.BusinessType;
import com.jun.repository.BusinessTypeRepository;
import com.jun.service.IBusinessTypeService;

@Service
public class BusinessTypeService implements IBusinessTypeService {
	
	@Autowired
	private BusinessTypeRepository businessTypeRepository;

	@Override
	public BusinessType findByName(String name) {
		return businessTypeRepository.findByName(name);
	}

	@Override
	public BusinessType save(BusinessType businessType) {
		return businessTypeRepository.save(businessType);
	}

}
