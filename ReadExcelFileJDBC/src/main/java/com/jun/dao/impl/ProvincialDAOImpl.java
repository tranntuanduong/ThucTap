package com.jun.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jun.dao.ProvincialDAO;
import com.jun.mapper.ProvincialMapper;
import com.jun.model.Provincial;

public class ProvincialDAOImpl extends AbstractDAO<Provincial> implements ProvincialDAO {
	private static final Logger log = Logger.getLogger(ProvincialDAOImpl.class);
	@Override
	public Provincial findByName(String name) {
		String sql = "SELECT * FROM provincial WHERE name = ?";
		List<Provincial> provincials = findByProperty(sql, new ProvincialMapper(), name);
		log.info(sql);
		return provincials.isEmpty() ? null : provincials.get(0);
	}
	@Override
	public Provincial findById(Long id) {
		String sql = "SELECT * FROM provincial WHERE id = ?";
		List<Provincial> provincials = findByProperty(sql, new ProvincialMapper(), id);
		log.info(sql);
		return provincials.isEmpty() ? null : provincials.get(0);
	}
}
