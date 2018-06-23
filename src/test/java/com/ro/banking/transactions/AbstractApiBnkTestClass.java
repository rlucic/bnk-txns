package com.ro.banking.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
public class AbstractApiBnkTestClass extends AbstractBnkTrxnTestClass {

	protected MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext webAppContext;
	
	//initialize the MockMvc object before each test;
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
	
}
