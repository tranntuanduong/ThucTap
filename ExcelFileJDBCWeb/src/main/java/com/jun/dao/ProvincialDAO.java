package com.jun.dao;

import com.jun.model.Provincial;

public interface ProvincialDAO extends GenericDAO<Provincial> {
	Provincial findByName(String name);
	Provincial findById(Long id);
	Long findIdByName(String name);
}
