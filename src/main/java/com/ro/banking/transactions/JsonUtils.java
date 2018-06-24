package com.ro.banking.transactions;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonUtils {

	public String mapToJson(Object obj, boolean pretty) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		if (pretty)
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		return mapper.writeValueAsString(obj);
	}
	
	public <T> T mapFromJson(String json, Class<T> claszz) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, claszz);
	}
	
}
