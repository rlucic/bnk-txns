package com.ro.banking.transactions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ro.banking.transactions.model.BankingTransaction;

@Repository
public interface BankingTransactionDAO extends CrudRepository<BankingTransaction, Long> {

	List<BankingTransaction> findAll();
	BankingTransaction findById(Long id);
	
	/**
	 * Returns a list of transactions with a minimum monetary value 
	 * 
	 * @param val
	 * @return
	 */
	@Query(name="queryForMax", value="Select bt FROM BankingTransaction bt WHERE bt.value <= :val")
	List<BankingTransaction> findForValueBelow(@Param("val") double val);
	
	/**
	 * Returns a list of transactions with a maximum monetary value 
	 * 
	 * @param val
	 * @return
	 */
	@Query(name="queryForMin", value="Select bt FROM BankingTransaction bt WHERE bt.value > :val")
	List<BankingTransaction> findForValueAbove(@Param("val") double val);
	
}
