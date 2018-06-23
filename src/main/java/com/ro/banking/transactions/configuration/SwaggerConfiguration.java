package com.ro.banking.transactions.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Value("${app.major.minor.version:1.XX}")
	String versionString;
	
	@Bean
	public Docket api(){
		
	    return new Docket(DocumentationType.SWAGGER_2)  
	    		.groupName("mainAPI")
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.ro.banking.transactions.api"))
	            .paths(PathSelectors.ant("/**"))
	            .build()
	            .apiInfo(apiInfo());
		
	}
	
    private ApiInfo apiInfo() {
    	
        return new ApiInfo(
          "API for soccer teams", 
          "Application for banking transactions", 
          versionString, 
          "Terms of service", 
          new Contact("R. G. L.", "www.example.com", "my-e-address@company.com"), 
          "License of API", "API license URL", Collections.emptyList());
   }
}
