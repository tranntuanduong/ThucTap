package com.jun.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jun.dao.BusinessTypeDAO;
import com.jun.mapper.BusinessTypeMapper;
import com.jun.model.BusinessType;

public class BusinessTypeDAOImpl extends AbstractDAO<BusinessType> implements BusinessTypeDAO {
	
	private static final Logger log = Logger.getLogger(BusinessTypeDAOImpl.class);
	@Override
	public BusinessType findByName(String name) {
		String sql = "SELECT * FROM business_type WHERE name = ?";
		List<BusinessType> businessTypes = findByProperty(sql, new BusinessTypeMapper(), name);
		
		log.info(sql);
		return businessTypes.isEmpty() ? null : businessTypes.get(0);
	}

	@Override
	public Long save(BusinessType businessType) {
		String sql = "INSERT INTO business_type(description, name) VALUES(?, ?)";
		
		log.info(sql);
		return save(sql, businessType.getDescription(), businessType.getName());
	}

	@Override
	public BusinessType findById(Long id) {
		String sql = "SELECT * FROM business_type WHERE id = ?";
		List<BusinessType> businessTypes = findByProperty(sql, new BusinessTypeMapper(), id);
		
		log.info(sql);
		return businessTypes.isEmpty() ? null : businessTypes.get(0);
	}

}
