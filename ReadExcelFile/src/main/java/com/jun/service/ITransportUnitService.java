package com.jun.service;

import java.util.List;

import com.jun.model.TransportUnit;

public interface ITransportUnitService {
	TransportUnit findByTaxCode(String taxCode);
	TransportUnit save(TransportUnit newTransportUnit);
	void saveList(List<TransportUnit> transportList);
	TransportUnit findByName(String name);
}
