package com.jun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
