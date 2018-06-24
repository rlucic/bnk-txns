package com.ro.banking.transactions.api;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/api")
@Api()
public class PingEndpoint {

	@ApiOperation(value="Certify that the application is up and running", response=String.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="All banking transactions"),
		}
	)	
	@RequestMapping(method=RequestMethod.GET, value="/ping")
	public ResponseEntity<String> ping(){
		HttpHeaders headers = new HttpHeaders();
		headers.add("Version", "1.0");
		headers.add("PING_RESPONSE_HEADER", "tx header");
		
		final LocalDateTime ldt = LocalDateTime.now();
		
		ResponseEntity<String> resp = new ResponseEntity<String>("pong @" + ldt, headers, HttpStatus.OK);
				//new ResponseEntity<String>("Pong", HttpStatus.OK);
		return resp;
	}
}
