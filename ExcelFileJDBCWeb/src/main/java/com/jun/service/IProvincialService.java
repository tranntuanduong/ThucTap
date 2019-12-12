package com.jun.service;

import com.jun.model.Provincial;

public interface IProvincialService {
	Provincial findByName(String name);
	Provincial findById(Long id);
	Long findIdByName(String name);
}
