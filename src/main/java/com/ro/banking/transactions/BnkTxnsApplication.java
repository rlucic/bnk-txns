package com.ro.banking.transactions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ro.banking.transactions.dao.BankingTransactionDAO;
import com.ro.banking.transactions.model.BankingTransaction;

@SpringBootApplication
public class BnkTxnsApplication {

	@Autowired
	private BankingTransactionDAO transactionDAO;
	
	public static void main(String[] args) {
		System.out.println("from the main app of BnkTxnsApplication");
		SpringApplication.run(BnkTxnsApplication.class, args);
	}
	
	/**
	 * used to initialize the DB with some transactions
	 */
	@PostConstruct
	public void init(){
		System.out.println("initializing the DB .... ");
		
		List<BankingTransaction> trxns = new ArrayList<BankingTransaction>();
		BankingTransaction t1 = new BankingTransaction("acct-01-2523", "acct-01-2141", 100.50, "CAD", "cust-id-01", "cust-id-02");
		BankingTransaction t2 = new BankingTransaction("acct-01-2141", "acct-02-6325", 44.78, "CAD", "cust-id-02", "cust-id-03");
		trxns.add(t1);
		trxns.add(t2);
		
		transactionDAO.save(trxns);
	}
}
