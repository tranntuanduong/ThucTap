package com.jun.service.impl;

import com.jun.dao.ProvincialDAO;
import com.jun.dao.impl.ProvincialDAOImpl;
import com.jun.model.Provincial;
import com.jun.service.IProvincialService;

public class ProvincialService implements IProvincialService {

	private ProvincialDAO provincialRepository;
	
	public ProvincialService() {
		if(provincialRepository == null)
			provincialRepository = new ProvincialDAOImpl();
	}

	@Override
	public Provincial findByName(String name) {
		return provincialRepository.findByName(name);
	}

	@Override
	public Provincial findById(Long id) {
		return provincialRepository.findById(id);
	}

	@Override
	public Long findIdByName(String provincialName) {
		return provincialRepository.findIdByName(provincialName);
	}
}
