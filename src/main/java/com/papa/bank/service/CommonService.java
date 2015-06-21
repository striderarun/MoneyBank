package com.papa.bank.service;

import java.util.List;



import com.papa.bank.domain.Transactions;
import com.papa.bank.dto.TransactionDTO;

public interface CommonService {

	List<TransactionDTO> getTransactionDTO(List<Transactions> transactions);
}
