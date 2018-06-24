package com.ro.banking.transactions.api;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ro.banking.transactions.AbstractApiBnkTestClass;
import com.ro.banking.transactions.JsonUtils;
import com.ro.banking.transactions.model.BankingTransaction;


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
	public void getAllTransactionsEndpointTest() throws Exception{
		String uri = "/api/v1.0";
		logger.info("Testing the getAllTransactionsEndpointTest");
		//create the MvcRestult for an endpoint
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertTrue(status == 200);
		
		List<BankingTransaction> transasctions = jsonUtils.mapFromJson(content, List.class);
		logger.info("list length: " + transasctions.size());

		Assert.assertTrue(transasctions.size() == 2);
	}
	

	//@Ignore
	@Test
	public void addTransactionEndpointTest() throws Exception{
		String uri = "/api/v1.0";
		logger.info("Testing the addTransactionEndpointTest");
		
		BankingTransaction bt = new BankingTransaction("acct-01-2141", "acct-02-6325", 3.75, "CAD", "cust-id-02", "cust-id-03");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
												.post(uri)
												.accept(MediaType.APPLICATION_JSON_VALUE)
												.contentType(MediaType.APPLICATION_JSON_VALUE)
												.content(jsonUtils.mapToJson(bt, false)))
												.andReturn();
	
		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();
		
		logger.info("status received: "  + status);
		Assert.assertTrue("Expecting 201, received: " + status, status == 201);
		
//		List<BankingTransaction> transasctions = jsonUtils.mapFromJson(content, List.class);
//		logger.info("list length: " + transasctions.size());
//
//		Assert.assertTrue(transasctions.size() == 3);
	}
	
	@Test
	public void deleteTransactionEndpointTest() throws Exception{
		String uri = "/api/v1.0/2";
		logger.info("Testing the deleteTransactionEndpointTest");
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders
									.delete(uri)
									.accept(MediaType.APPLICATION_JSON_VALUE))
									.andReturn();
		
		int status = result.getResponse().getStatus();
		//Assert that "No content" was returned (204)
		Assert.assertTrue("expected 204, received " + status, status == 204);
	}
	
}
