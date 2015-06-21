package com.papa.bank.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.papa.bank.service.IntegrationService;

@Service
public class IntegrationServiceImpl implements IntegrationService{

	@Override
	public void receiver(String name) {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println("Received message : " + name);
	}

	@Override
	public String respond(String message) {
		return message + " Message received";
	}
}
