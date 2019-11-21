package com.jun.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jun.model.PhoneNumber;
import com.jun.service.IPhoneNumberService;

@RestController
public class PhoneNumberAPI {
	@Autowired
	private IPhoneNumberService phoneNumberService;
	
	@GetMapping(value = {"/api/phoneNumber"})
	public PhoneNumber findById(@RequestParam Long id) {
		PhoneNumber phoneNumber = phoneNumberService.findById(id);
		return phoneNumber;
	} 	
	
	@GetMapping(value = {"/api/phoneNumber/findAll"})
	public List<PhoneNumber> findAll() {
		return phoneNumberService.findAll();
	}
	
	@DeleteMapping(value = {"/api/phoneNumber"})
	public void deleteBuilding(@RequestParam Long id) {
		phoneNumberService.delete(id);
	}
	
	@PostMapping(value = {"/api/phoneNumber"})
	public PhoneNumber save(@RequestBody PhoneNumber model) {
		return phoneNumberService.save(model);
	} 
}
