package com.jun.service.impl;

import java.util.List;

import com.jun.model.PhoneNumber;
import com.jun.repository.IPhoneNumberRepository;
import com.jun.repository.impl.PhoneNumberRepositoryImpl;
import com.jun.service.IPhoneNumberService;

public class PhoneNumberServiceImpl implements IPhoneNumberService {
	
	IPhoneNumberRepository phoneNumberRepository = new PhoneNumberRepositoryImpl();

	@Override
	public PhoneNumber save(PhoneNumber phoneNumber) {
		phoneNumberRepository.save(phoneNumber);
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhoneNumber findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhoneNumber> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
