package com.jun.service.impl;

import java.util.List;

import com.jun.dao.CompanyDAO;
import com.jun.dao.impl.CompanyDAOImpl;
import com.jun.model.Company;
import com.jun.service.ICompanyService;

public class CompanyService implements ICompanyService{

	private CompanyDAO companyDAO;
	
	public CompanyService() {
		if(companyDAO == null)
			companyDAO = new CompanyDAOImpl();
	}

	@Override
	public Company save(Company newCompany) {
		Long companyId = companyDAO.save(newCompany);
		Company company = companyDAO.findById(companyId);
		return company;
	}

	@Override
	public void saveList(List<Company> transportList) {
		for(Company company : transportList) {
			companyDAO.save(company);
		}
	}

	@Override
	public Company findByName(String name) {
		return companyDAO.findByName(name);
	}

	@Override
	public Company update(Company newCompany) {
		companyDAO.update(newCompany);
		Company company = companyDAO.findById(newCompany.getId());
		return company;
	}

	@Override
	public Company findById(Long id) {
		return companyDAO.findById(id);
	}

	@Override
	public List<Company> findByCode(String code) {
		return companyDAO.findByCode(code);
	}


}
