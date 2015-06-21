package com.papa.bank.dto;

import java.util.List;

public class UserDetailsDTO {

	private AccountDetailsDTO accountDetails;
	private List<TransactionDTO> transactionDetails;

	public AccountDetailsDTO getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(AccountDetailsDTO accountDetails) {
		this.accountDetails = accountDetails;
	}
	public List<TransactionDTO> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<TransactionDTO> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}


}
