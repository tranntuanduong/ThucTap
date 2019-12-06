package com.jun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.model.Provincial;

public interface ProvincialRepository extends JpaRepository<Provincial, Long> {
	Provincial findByName(String name);
}
