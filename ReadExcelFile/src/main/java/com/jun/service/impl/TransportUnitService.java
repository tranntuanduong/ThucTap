package com.jun.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.model.TransportUnit;
import com.jun.repository.TransportUnitRepository;
import com.jun.service.ITransportUnitService;

@Service
public class TransportUnitService implements ITransportUnitService{
	
	@Autowired
	private TransportUnitRepository transportUnitRepository;
	
	@Override
	public TransportUnit findByTaxCode(String taxCode) {
		return transportUnitRepository.findByTaxCode(taxCode);
	}

	@Override
	public TransportUnit save(TransportUnit newTransportUnit) {
		return transportUnitRepository.save(newTransportUnit);
	}

	@Override
	@Transactional
	public void saveList(List<TransportUnit> transportList) {
		for(TransportUnit transportUnit : transportList) {
			transportUnitRepository.save(transportUnit);
		}
	}

	@Override
	public TransportUnit findByName(String name) {
		return transportUnitRepository.findByName(name);
	}

}
