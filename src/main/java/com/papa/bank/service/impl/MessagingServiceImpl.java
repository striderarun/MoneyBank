package com.papa.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.papa.bank.service.IntegrationService;
import com.papa.bank.service.MessagingService;

@Service
public class MessagingServiceImpl implements MessagingService{

	@Autowired
	private MessageChannel messageChannel;

	@Autowired
	private IntegrationService messageGateway;


	@Override
	public void sendMessage(String message) {
		System.out.println("Sending Message");
		messageChannel.send(MessageBuilder.withPayload(message).build(),5L);
		System.out.println("Sent Message");

	}

	@Override
	public String sendMessageGateway(String message) {
		System.out.println("Sending Message through Gateway");
		return messageGateway.respond(message);
	}
}
