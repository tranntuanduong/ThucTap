package com.jun.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jun.model.PhoneNumber;
import com.jun.service.IPhoneNumberService;
import com.jun.service.impl.PhoneNumberServiceImpl;

@Path("/phonenumber")
public class PhoneNumberController {
	
	IPhoneNumberService phoneNumberService = new PhoneNumberServiceImpl();
		
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public PhoneNumber addEmployee(PhoneNumber phoneNumber) {
        return phoneNumberService.save(phoneNumber);
    }
}
