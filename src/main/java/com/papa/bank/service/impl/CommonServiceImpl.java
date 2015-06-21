package com.papa.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.bank.domain.Transactions;
import com.papa.bank.dto.TransactionDTO;
import com.papa.bank.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private DozerBeanMapper mapper;


	public List<TransactionDTO> getTransactionDTO (List<Transactions> transactions) {
		List<TransactionDTO> transactionsDTO = new ArrayList<TransactionDTO>();
		for (Transactions transaction : transactions) {
			TransactionDTO transactionDTO = mapper.map(transaction, TransactionDTO.class);
			transactionsDTO.add(transactionDTO);
		}
		return transactionsDTO;
	}
}
