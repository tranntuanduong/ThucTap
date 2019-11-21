package com.jun.service;

import java.util.List;

import com.jun.model.PhoneNumber;

public interface IPhoneNumberService {
	PhoneNumber save(PhoneNumber phoneNumber);
	void delete(Long id);
	PhoneNumber findById(Long id);
	List<PhoneNumber> findAll();
}
