package com.jun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jun.model.Provincial;

public class ProvincialMapper implements RowMapper<Provincial>{

	@Override
	public Provincial mapRow(ResultSet resultSet) {
		Provincial provincial = new Provincial();
		try {
			provincial.setId(resultSet.getLong("id"));
			provincial.setName(resultSet.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincial;
	}

}
