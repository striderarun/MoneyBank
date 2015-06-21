package com.papa.bank.service;

import org.springframework.stereotype.Service;

import com.papa.bank.domain.User;
import com.papa.bank.dto.AccountDetailsDTO;
import com.papa.bank.dto.StatusDTO;
import com.papa.bank.dto.UserDetailsDTO;
import com.papa.bank.request.TransferRequestBean;
import com.papa.bank.request.UserRequestBean;

public interface BankingService {

	User authenticateUsers(UserRequestBean bean);

	UserDetailsDTO getAccountDetails(String userName);

	boolean transferFunds(TransferRequestBean transfer, String userName);
}
