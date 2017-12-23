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

	@Test
	public void findAnItemWithSalePrice() {
		List<Float> names = given().queryParam("query", "ipod").queryParam("format", "json")
				.queryParam("apiKey", "bcu25etp7zbd6nn6hveuq3pg").when().get("v1/search").then().extract()
				.path("items.findAll{it.name==~/iPod.*/}.msrp");
		// path();
		// List<String> name
		for (Float name : names)

			System.out.println("The msrp values of items whose name starts with iPod " + name);
	}

}
