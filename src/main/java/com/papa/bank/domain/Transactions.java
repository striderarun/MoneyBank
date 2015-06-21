package com.papa.bank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Transactions")
@SequenceGenerator(name = "transactionSeq", sequenceName = "transactionSeq", allocationSize = 1)
public class Transactions {
	private Integer transactionId;
	private Integer accountNo;
	private String transactionRemarks;
	private String transactionType;
	private String transactionAmount;
	private String userName;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
	@Column(name="transactionId")
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	@Column(name="accountNumber")
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name="transactionRemarks")
	public String getTransactionRemarks() {
		return transactionRemarks;
	}
	public void setTransactionRemarks(String transactionRemarks) {
		this.transactionRemarks = transactionRemarks;
	}
	@Column(name="transactionType")
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Column(name="transactionAmount")
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Column(name="userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}
