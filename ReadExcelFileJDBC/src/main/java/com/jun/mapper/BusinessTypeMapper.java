package com.jun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jun.model.BusinessType;

public class BusinessTypeMapper implements RowMapper<BusinessType>{

	@Override
	public BusinessType mapRow(ResultSet resultSet) {
		BusinessType businessType = new BusinessType();
		try {
			businessType.setId(resultSet.getLong("id"));
			businessType.setDescription(resultSet.getString("description"));
			businessType.setName(resultSet.getString("name"));
			//vehicleList
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return businessType;
	}

}
