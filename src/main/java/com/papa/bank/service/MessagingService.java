package com.papa.bank.service;

public interface MessagingService {

	void sendMessage(String message);

	public String sendMessageGateway(String message);
}
