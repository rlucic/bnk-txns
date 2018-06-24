package com.ro.banking.transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ro.banking.transactions.dao.BankingTransactionDAO;
import com.ro.banking.transactions.model.BankingTransaction;

@Service
public class BankingTransactionsService {

	@Autowired
	BankingTransactionDAO transactionDAO;
	
	public List<BankingTransaction> getAllBankingTransactions(){
		return transactionDAO.findAll();
	}
	
	public BankingTransaction getTransactionById(Long id){
		return transactionDAO.findById(id);
	}
	
	public BankingTransaction deleteTransactionById(Long id){
		BankingTransaction trxn = transactionDAO.findById(id);

		//transactionDAO.exists(id);
		if(trxn == null){
			System.out.println("transaction not found for id=" + id);
			return null;
		}
		else{
			transactionDAO.delete(id);
			System.out.println("transaction deleted: " + trxn.toString());
		}
		return trxn;
	}
	
	public BankingTransaction addBankingTransaction(BankingTransaction trxn){
		
		BankingTransaction newTrxn = transactionDAO.save(trxn);
		System.out.println("transaction created: " + newTrxn.toString());
		return newTrxn;
		
	}
	
	public BankingTransaction updateBankingTransaction(BankingTransaction trxn){
		BankingTransaction updated;

		boolean isPresent = transactionDAO.exists(trxn.getId());
		
		//transactionDAO.exists(id);
		if(!isPresent){
			System.out.println("transaction not found for id=" + trxn.getId());
			return null;
		}
		else{
			updated = transactionDAO.save(trxn);
			System.out.println("transaction updated: " + trxn.toString());
		}
		return updated;		
		
	}
	
	
	/**
	 * Returns a list of transactions with a maximum monetary value 
	 * 
	 * @param val
	 * @return
	 */
	public List<BankingTransaction> findForValueBelow(double val){
		return transactionDAO.findForValueBelow(val);
	}
	
	/**
	 * Returns a list of transactions with a minimum monetary value 
	 * 
	 * @param val
	 * @return
	 */
	public List<BankingTransaction> findForValueAbove(double val){
		return transactionDAO.findForValueAbove(val);
	}	
}
