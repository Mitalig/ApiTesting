package com.apitesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UsingGroovyJsonPath {
	
	
	@BeforeClass
	  public void setBaseUri () {

	    RestAssured.baseURI = "http://issuance.planturtle.com/";
	  }
	
	  
	  @Test
	  public void singleAssertion()  {
		  Response res= given().relaxedHTTPSValidation()
					.contentType(ContentType.JSON).body("{\"page\":1,\"limit\":100,\"filter\":{\"vertical\":[],\"status\":[],\"type\":[]}}").when()
					.post("api/policyissuance").then()
					.statusCode(200).extract().response();
		  
		  System.out.println(res.asString());
		  List<String > values = res.path("data.findAll{it.requestId=='AF9GGTT71FX'}.policyIssuanceId");
		  System.out.println(values.get(0));

	  }
	  

}
