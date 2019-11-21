package com.jun.service;

import java.util.List;

import com.jun.model.PhoneNumber;

public interface IPhoneNumberService {
	PhoneNumber findById(Long id);
	List<PhoneNumber> findAll();
	PhoneNumber save(PhoneNumber newPhoneNumber);
	void delete(Long id);
}
