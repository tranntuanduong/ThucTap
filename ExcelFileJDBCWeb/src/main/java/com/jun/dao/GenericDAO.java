package com.jun.dao;

import java.util.List;

import com.jun.mapper.RowMapper;

public interface GenericDAO<T> {
	Long save(String sql, Object... parameters);
	<T> List<T> findByProperty(String sql, RowMapper<T> rowMapper, Object param);
}
