package com.jun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jun.model.Company;
import com.jun.model.Provincial;

public class CompanyMapper implements RowMapper<Company>{
	
	@Override
	public Company mapRow(ResultSet resultSet) {
		Company company = new Company();
		try {
			company.setId(resultSet.getLong("id"));
			company.setName(resultSet.getString("name"));
			company.setPhoneNumber(resultSet.getNString("phone_number"));
			company.setTaxCode(resultSet.getString("taxt_code"));
			company.setCode(resultSet.getString("code"));
			Provincial provincial = new Provincial();
				provincial.setId(resultSet.getLong("provincial_id"));
			company.setProvincial(provincial);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return company;
	}

}
