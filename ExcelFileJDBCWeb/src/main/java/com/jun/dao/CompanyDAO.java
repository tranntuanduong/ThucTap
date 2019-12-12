package com.jun.dao;

import java.util.List;

import com.jun.model.Company;

public interface CompanyDAO extends GenericDAO<Company>{
	Company findByName(String name);
	Long save(Company transportUnit);
	Long update(Company transportUnit);
	Company findById(Long id);
	List<Company> findByCode(String name);
	
}
