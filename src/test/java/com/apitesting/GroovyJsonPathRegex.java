package com.apitesting;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GroovyJsonPathRegex {

	@BeforeClass
	public void setBaseUri() {

		RestAssured.baseURI = "http://api.walmartlabs.com/";
	}

	
	//The msrp values of items whose name starts with iPod 
	@Test
	public void findAnItemWhoseNameStartsWithiPod() {
		
		List<Float> msrps = given().queryParam("query", "ipod").queryParam("format", "json")
				.queryParam("apiKey", "bcu25etp7zbd6nn6hveuq3pg").when().get("v1/search").then().extract()
				.path("items.findAll{it.name==~/iPod.*/}.msrp");
		
		for (Float msrp : msrps)

			System.out.println("The msrp values of items whose name starts with iPod " + msrp);
	}
	
	//The salePrice values of items whose name ends with Player 
	
	@Test
	public void findAnItemWhoseNameEndsWithPlayer() {
		
		List<Float> salePrices = given().queryParam("query", "ipod").queryParam("format", "json")
				.queryParam("apiKey", "bcu25etp7zbd6nn6hveuq3pg").when().get("v1/search").then().extract()
				.path("items.findAll{it.name==~/.*Player/}.salePrice");
		
		for (Float salePrice : salePrices)

			System.out.println("The salePrice values of items whose name ends with Player " + salePrice);
	}
	
	

}
