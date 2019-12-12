package com.jun.service;

import java.util.List;

import com.jun.model.Company;

public interface ICompanyService {
	Company save(Company newTransportUnit);
	Company update(Company newTransportUnit);
	void saveList(List<Company> transportList);
	Company findByName(String name);
	Company findById(Long id);
	List<Company> findByCode(String code);
}
