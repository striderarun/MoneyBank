package com.papa.bank.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.bank.dao.BankingDao;
import com.papa.bank.domain.Transactions;
import com.papa.bank.domain.User;
import com.papa.bank.dto.AccountDetailsDTO;
import com.papa.bank.dto.StatusDTO;
import com.papa.bank.dto.TransactionDTO;
import com.papa.bank.dto.UserDetailsDTO;
import com.papa.bank.request.TransferRequestBean;
import com.papa.bank.request.UserRequestBean;
import com.papa.bank.service.BankingService;
import com.papa.bank.service.CommonService;

@Service
public class BankingServiceImpl implements BankingService{

	@Autowired
	BankingDao bankingDao;

	@Autowired
	CommonService commonService;

	@Autowired
	DozerBeanMapper mapper;

	public User authenticateUsers(UserRequestBean bean) {
		User user = new User();
		user.setUserName(bean.getUserName());
		user.setPassword(bean.getPassword());
		User userDetail = bankingDao.authenticateUsers(user);
		return userDetail;
	}



	public UserDetailsDTO getAccountDetails(String userName) {
		AccountDetailsDTO accountDetails = null;
		UserDetailsDTO userDetails = new UserDetailsDTO();
		User user = bankingDao.getAccountDetails(userName);
		if (null != user) {
			accountDetails = mapper.map(user, AccountDetailsDTO.class);
		}
		List<Transactions> transactionList = bankingDao.getTransactionDetails(userName);
		List<TransactionDTO> transactions =  commonService.getTransactionDTO(transactionList);
		userDetails.setAccountDetails(accountDetails);
		userDetails.setTransactionDetails(transactions);
		return userDetails;
	}

	public boolean transferFunds(TransferRequestBean transfer, String userName) {
		boolean transferStatus = false;
		User user = bankingDao.transferFunds(transfer, userName);
		if (null != user) {
			transferStatus = true;
		}
		return transferStatus;

	}



}
