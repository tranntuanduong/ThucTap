package com.jun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.model.Provincial;
import com.jun.repository.ProvincialRepository;
import com.jun.service.IProvincialService;

@Service
public class ProvincialService implements IProvincialService {
	@Autowired
	private ProvincialRepository provincialRepository;
	
	@Override
	public Provincial findByName(String name) {
		return provincialRepository.findByName(name);
	}
}
