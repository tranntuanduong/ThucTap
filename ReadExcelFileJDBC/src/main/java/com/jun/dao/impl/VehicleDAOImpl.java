package com.jun.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.jun.dao.VehicleDAO;
import com.jun.mapper.VehicleMapper;
import com.jun.model.Vehicle;

public class VehicleDAOImpl extends AbstractDAO<Vehicle> implements VehicleDAO {
	private static final Logger log = Logger.getLogger(VehicleDAOImpl.class);
	@Override
	public Long save(Vehicle vehicle) {
		StringBuilder sql = new StringBuilder("INSERT INTO vehicle(license_plate, ");
		sql.append("seat, weight, business_type_id, provincial_id, transport_unit_id,"
				+ " data_transport_id) VALUES(?,?,?,?,?,?,?)");
		Long vehicleId = save(sql.toString(), vehicle.getLicensePlate(),
				vehicle.getSeat(), vehicle.getWeight(), vehicle.getBusinessType().getId(),
				vehicle.getProvincial().getId(), vehicle.getTransportUnit().getId(),
				vehicle.getDataTransport().getId());
		
		log.info(sql);
		return vehicleId;
	}
	@Override
	public Vehicle findByLicensePlate(String licensePlate) {
		String sql = "SELECT * FROM vehicle WHERE license_plate = ?";
		List<Vehicle> vehicle = findByProperty(sql, new VehicleMapper(), licensePlate);
		log.info(sql);
		return vehicle.isEmpty() ? null : vehicle.get(0);
	}
	@Override
	public Long update(Vehicle vehicle) {
		StringBuilder sql = new StringBuilder("UPDATE vehicle SET ");
		sql.append("license_plate=?, seat=?, weight=?, business_type_id=?, provincial_id=?, ");
		sql.append("transport_unit_id=?, data_transport_id=? WHERE id = ?");
		Long vehicleId = save(sql.toString(), vehicle.getLicensePlate(),
				vehicle.getSeat(), vehicle.getWeight(), vehicle.getBusinessType().getId(),
				vehicle.getProvincial().getId(), vehicle.getTransportUnit().getId(),
				vehicle.getDataTransport().getId(), vehicle.getId());
		
		log.info(sql);
		return vehicleId;
	}
	@Override
	public Vehicle findById(Long id) {
		String sql = "SELECT * FROM vehicle WHERE id = ?";
		List<Vehicle> vehicle = findByProperty(sql, new VehicleMapper(), id);
		return vehicle.isEmpty() ? null : vehicle.get(0);
	}
	@Override
	public List<Vehicle> findAll() {
		String sql = "SELECT * FROM vehicle";
		List<Vehicle> vehicleList = findByProperty(sql, new VehicleMapper(), null);
		return vehicleList;
	}
	@Override
	public List<Vehicle> findByProvincial(Object param) {
		StringBuilder sql = new StringBuilder("");
		sql.append("SELECT V.id, V.license_plate, V.seat, V.weight, V.business_type_id, V.provincial_id, ");
		sql.append("V.transport_unit_id, V.data_transport_id ");
		sql.append("FROM vehicle V JOIN provincial P on V.provincial_id = P.id ");
		sql.append("WHERE V.provincial_id = ?");
		List<Vehicle> vehicleList = findByProperty(sql.toString(), new VehicleMapper(), param);
		log.info(sql.toString());
		return vehicleList;
	}

}
