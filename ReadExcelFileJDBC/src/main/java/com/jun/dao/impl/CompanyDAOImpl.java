package com.jun.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jun.dao.CompanyDAO;
import com.jun.mapper.CompanyMapper;
import com.jun.model.Company;

public class CompanyDAOImpl extends AbstractDAO<Company> implements CompanyDAO{
	private static final Logger log = Logger.getLogger(CompanyDAOImpl.class);
	@Override
	public Company findByName(String name) {
		String sql = "SELECT * FROM company WHERE name = ?";
		List<Company> transportUnits = findByProperty(sql, new CompanyMapper(), name);
		log.info(sql);
		return transportUnits.isEmpty() ? null : transportUnits.get(0);
	}

	@Override
	public Long save(Company company) {
		String sql = "INSERT INTO company(name, phone_number, taxt_code, provincial_id, code) VALUES(?, ?, ?, ?, ?)";
		log.info(sql);
		return save(sql, company.getName(), company.getPhoneNumber(), 
				company.getTaxCode(), company.getProvincial().getId(), company.getCode());
	}

	@Override
	public Company findById(Long id) {
		String sql = "SELECT * FROM company WHERE id = ?";
		List<Company> company = findByProperty(sql, new CompanyMapper(), id);
		log.info(sql);
		return company.isEmpty() ? null : company.get(0);
	}

	@Override
	public Long update(Company company) {
		String sql = "UPDATE company SET name=?, phone_number=?, taxt_code=?, provincial_id=?, code=? WHERE id=?";
		log.info(sql);
		return save(sql, company.getName(), company.getPhoneNumber(), 
				company.getTaxCode(), company.getProvincial().getId(), company.getCode(), company.getId());
	}

	@Override
	public List<Company> findByCode(String name) {
		String sql = "SELECT * FROM company WHERE code = ?";
		List<Company> company = findByProperty(sql, new CompanyMapper(), name);
		log.info(sql);
		return company;
	}

}
