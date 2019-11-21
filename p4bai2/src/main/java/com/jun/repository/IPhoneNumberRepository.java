package com.jun.repository;

import java.util.List;

import com.jun.model.PhoneNumber;

public interface IPhoneNumberRepository {
	Long save(PhoneNumber phoneNumber);
	void delete(Long id);
	PhoneNumber findById(Long id);
	List<PhoneNumber> findAll();
}
