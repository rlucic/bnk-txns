package com.ro.banking.transactions.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ro.banking.transactions.model.BankingTransaction;

public interface BankingTransactionDAO extends CrudRepository<BankingTransaction, Long> {

	List<BankingTransaction> findAll();
	BankingTransaction findById(Long id);
	
}
