package com.ro.banking.transactions.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ro.banking.transactions.AbstractApiBnkTestClass;
import com.ro.banking.transactions.JsonUtils;


public class BankingTransactionApiTest extends AbstractApiBnkTestClass {

	@Autowired
	private JsonUtils jsonUtils;
	
	@Before
	public void setUp(){
		logger.debug("--------------------");
		super.setUp();
		logger.debug("--------------------");
	}
	
	@Test
	public void firstTest(){
		logger.info("Testing the Banking Transaction APIs");
	}
	
}
