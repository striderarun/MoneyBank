package com.papa.bank.dao;

import java.util.List;

import com.papa.bank.domain.Transactions;
import com.papa.bank.domain.User;
import com.papa.bank.request.TransferRequestBean;


public interface BankingDao  {

	User authenticateUsers(User user);

	List<Transactions> getTransactionDetails(String userName);

	User getAccountDetails(String userName);

	User transferFunds(TransferRequestBean transfer, String userName);

}
