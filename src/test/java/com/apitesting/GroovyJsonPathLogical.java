package com.apitesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.List;

public class GroovyJsonPathLogical {
	
	  @BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "http://api.walmartlabs.com/";
	  }
	
	@Test
	  public void findAnItemWithSalePrice()  {
		List<String>name=given()
		 .queryParam("query", "ipod")
		 .queryParam("format", "json")
		 .queryParam("apiKey", "bcu25etp7zbd6nn6hveuq3pg")
		 .when()
		 .get("v1/search")
		 .then()
		 .extract()
		 .path("items.findAll{it.salePrice>350}.name");
		 //path();
		 //List<String> name 
		
		 System.out.println("The value is "+name.get(0));
	}
	
	
}


