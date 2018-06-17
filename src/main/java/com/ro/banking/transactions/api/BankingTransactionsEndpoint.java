package com.ro.banking.transactions.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ro.banking.transactions.model.BankingTransaction;
import com.ro.banking.transactions.service.BankingTransactionsService;

import java.util.List;

import javax.websocket.server.PathParam;


@RestController
@RequestMapping(value="/api/v1.0")
public class BankingTransactionsEndpoint {

	@Autowired
	private BankingTransactionsService bankingService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<BankingTransaction>> transactions(){
		System.out.println("Inside getTransactions");
		List<BankingTransaction> transactions =bankingService.getAllBankingTransactions();
		
		return new ResponseEntity<List<BankingTransaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(path="/min", method=RequestMethod.GET)
	public ResponseEntity<List<BankingTransaction>> greaterThan(@RequestParam(name="val", required=true) String value){
		System.out.println("Inside transactions value greaterThan: " + value);
		 
		return new ResponseEntity(HttpStatus.OK);
	}

	@RequestMapping(path="/max", method=RequestMethod.GET)
	public ResponseEntity<List<BankingTransaction>>    lessThan(@RequestParam(name="val", required=true) String value){
		System.out.println("Inside transactions lessThan: " + value);
		 
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * Retrieve a transaction by id
	 * 
	 */
	@RequestMapping(path="/{id}", 
			method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankingTransaction> getTransaction(@PathVariable Long id){
		System.out.println("Inside getTransaction, id: " + id);
		BankingTransaction trxn = bankingService.getTransactionById(id);
		ResponseEntity<BankingTransaction> resp;
		if (trxn == null)
			resp = new ResponseEntity<BankingTransaction>(HttpStatus.NOT_FOUND);
		else{
			resp = new ResponseEntity<BankingTransaction>(trxn, HttpStatus.OK);
		}
		return resp;
	}
	
	
	/**
	 * Creates a transaction from a JSON structure
	 * 
	 * @param toCreate
	 * @return
	 */
	@RequestMapping(path="", 
			method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankingTransaction> addBankingTransaction(@RequestBody BankingTransaction toCreate){
		System.out.println("Inside addBankingTransaction, with: " + toCreate.toString());
		
		if(toCreate.getId() != null){
			System.err.println("Can't create a transaction that has an id present");
			return new ResponseEntity<BankingTransaction>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		BankingTransaction created = bankingService.addBankingTransaction(toCreate);
		
		return new ResponseEntity<BankingTransaction>(HttpStatus.CREATED);
	}
	

	/**
	 * Update an existing transaction, needs a transaction that has an ID
	 * 
	 * @param toUpdate
	 * @return
	 */
	@RequestMapping(path="", 
			method=RequestMethod.PUT, 
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankingTransaction> updateTransaction(@RequestBody BankingTransaction toUpdate){
		System.out.println("Inside updateTransaction, updating with: " + toUpdate);
		
		
		if(toUpdate == null){
			System.err.println("Can't update a transaction that is null");
			return new ResponseEntity<BankingTransaction>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		if(toUpdate.getId() == null){
			System.err.println("Can't update a transaction that hasn't an id present");
			return new ResponseEntity<BankingTransaction>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		BankingTransaction t = bankingService.updateBankingTransaction(toUpdate); 
		if(t==null){
			System.err.println("Can't update a transaction that doesn't exist");
			return new ResponseEntity<BankingTransaction>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return new ResponseEntity<BankingTransaction>(t, HttpStatus.OK);
	}
	
	
	/**
	 * Remove/DELETE an existing transaction
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path="/{id}", 
			method=RequestMethod.DELETE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BankingTransaction> deleteTransaction(@PathVariable Long id){
		System.out.println("Inside deleteTransaction, id: " + id);

		BankingTransaction trxn = bankingService.deleteTransactionById(id);
		
		ResponseEntity<BankingTransaction> resp;
		if (trxn == null)
			resp = new ResponseEntity<BankingTransaction>(HttpStatus.NOT_FOUND);
		else{
			resp = new ResponseEntity<BankingTransaction>(HttpStatus.NO_CONTENT);
		}
		return resp;

	}
	
}
