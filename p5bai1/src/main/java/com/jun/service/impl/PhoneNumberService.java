package com.jun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.model.PhoneNumber;
import com.jun.repository.PhoneNumberRepository;
import com.jun.service.IPhoneNumberService;

@Service
public class PhoneNumberService implements IPhoneNumberService {
	@Autowired
	 PhoneNumberRepository phoneNumberRepository;

	@Override
	public PhoneNumber findById(Long id) {
		PhoneNumber phoneNumber = phoneNumberRepository.findById(id).get();
		return phoneNumber;
	}

	@Override
	public List<PhoneNumber> findAll() {
		return phoneNumberRepository.findAll();
	}

	@Override
	public PhoneNumber save(PhoneNumber newPhoneNumber) {
		
		return phoneNumberRepository.save(newPhoneNumber);
	}

	@Override
	public void delete(Long id) {
		phoneNumberRepository.deleteById(id);
	}

}
