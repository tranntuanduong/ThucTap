package com.jun.service;

import com.jun.model.BusinessType;

public interface IBusinessTypeService {
	BusinessType findByName(String name);
	BusinessType save(BusinessType businessType);
}
